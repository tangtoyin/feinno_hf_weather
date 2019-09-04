package com.ucss.elementary.tnwn.service;

import com.ucss.elementary.tnwn.mapper.tnwn.TDVericodeMapper;
import com.ucss.elementary.tnwn.model.database.SysDict;
import com.ucss.elementary.tnwn.model.database.TDVericode;
import com.ucss.elementary.tnwn.model.database.TDVericodeExample;
import com.ucss.elementary.tnwn.util.DateHelper;
import com.ucss.elementary.tnwn.util.TConverter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by HL on 2017/12/29.
 */
@Service
public class VericodeService {

    @Autowired
    TDVericodeMapper tdVericodeMapper;
    @Autowired
    SysService sysService;

    //新增验证码 类型, 1注册 2短信登录 3找回密码
    public String newVericode(String phone, short type) {
        if (StringUtils.isEmpty(phone)) {
            return null;
        }
        //生成六位随机数
        String vericode = TConverter.toSafeString((int) ((Math.random() * 9 + 1) * 100000));
        TDVericode tdVericode = new TDVericode();
        tdVericode.setCreatetime(new Date());
        tdVericode.setCreatetime(new Date());
        tdVericode.setUsed((short) 0);
        tdVericode.setPhone(phone);
        tdVericode.setVericode(vericode);
        tdVericode.setType(type);
        //有效期五分钟
        tdVericode.setValidtime(DateHelper.addMinute(new Date(), 5));
        tdVericodeMapper.insertSelective(tdVericode);
        return tdVericode.getVericode();
    }

    //根据验证码和手机号查询验证码
    public TDVericode getByPhoneAndType(String phone, short type) {
        if (StringUtils.isEmpty(phone)) {
            return null;
        }
        TDVericodeExample example = new TDVericodeExample();
        example.createCriteria().andValidtimeGreaterThan(new Date()).andUsedEqualTo((short) 0)
                .andPhoneEqualTo(phone).andTypeEqualTo(type);
        example.setOrderByClause("createtime desc nulls last");
        return TConverter.GetFirstOrDefualt(tdVericodeMapper.selectByExample(example));
    }

    //验证验证码
    public boolean verifyCode(String phone, short type, String code) {
        if (StringUtils.isEmpty(code)) {
            return false;
        }
        if (isSMS1234loginWhite(phone,code)) {
            return true;
        }
        TDVericode vericode = getByPhoneAndType(phone, type); //检验USED字段是否为0
        if (vericode == null) {
            return false;
        }
        //验证成功
        if (vericode.getVericode().equals(code)) {
            //过期验证码
            useVericode(vericode.getId());
            return true;
        }
        //验证失败
        else {
            return false;
        }
    }

    private boolean isSMS1234loginWhite(String phone,String code){
        if(!"1234".equals(code)) {
            return false;
        }
        int isopen1234=TConverter.ObjectToInt(sysService.getOptionNameByTypecodeAndCode("sys.verifycode_config","isopen_1234"));
        if(isopen1234==0) {
            return false;
        } else if(isopen1234==2) {
            return true;
        } else {
            List<SysDict> list=sysService.getOptionsByTypecode("sys.verifycode_whitephone");
            if(list==null||list.size()==0) {
                return false;
            }
            for (SysDict dict:list){
                if(phone.equals(dict.getLabel())) {
                    return true;
                }
            }
        }
        return false;
    }

    //不过期验证码
    public boolean verifyCode2(String phone, short type, String code) {
        if (StringUtils.isEmpty(code)) {
            return false;
        }
        if (isSMS1234loginWhite(phone,code)) {
            return true;
        }
        TDVericode vericode = getByPhoneAndType(phone, type); //检验USED字段是否为0
        if (vericode == null) {
            return false;
        }
        //验证成功
        if (vericode.getVericode().equals(code)) {
            return true;
        }
        //验证失败
        else {
            return false;
        }
    }

    //更新验证码状态
    public void useVericode(long vericodeID) {
        if (vericodeID <= 0) {
            return;
        }
        //更新为已使用
        TDVericode vericode = new TDVericode();
        vericode.setId(vericodeID);
        vericode.setUsed((short) 1);
        vericode.setUpdatetime(new Date());
        tdVericodeMapper.updateByPrimaryKey(vericode);
    }

    //获取今天下发次数
    public int countToday(String phone) {
        TDVericodeExample example = new TDVericodeExample();
        example.createCriteria().andValidtimeGreaterThan(DateHelper.getDayBeginTime(new Date())).andPhoneEqualTo(phone);
        return tdVericodeMapper.countByExample(example);
    }


}
