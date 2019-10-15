package com.ucss.elementary.tnwn.controller.tnwn;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ucss.elementary.tnwn.constant.tnwn.Status;
import com.ucss.elementary.tnwn.model.database.*;
import com.ucss.elementary.tnwn.service.tnwn.BasicDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/tnwn/basicdata")
@Api(description = "号段基础数据管理")
public class BasicDataController {

    public Logger log= LoggerFactory.getLogger(BasicDataController.class);
    @Autowired
    private BasicDataService basicDataService;

    @ApiOperation(value = "根据typecode和code获取值", notes = "根据typecode和code获取值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public Map<String ,Object> getBasicData(@RequestParam(value = "PARAM") String param, HttpSession session){
        Map<String,Object> map=new HashMap<>();
        JSONObject jsonObject = JSONObject.parseObject(param);
        int pageSize = Integer.parseInt(jsonObject.get("pageSize").toString());
        int pageNum=Integer.parseInt(jsonObject.get("pageNum").toString());
        TBNumrange tbNumrange = (TBNumrange) jsonObject.get("tbNumrange");
        String numrange = tbNumrange.getNumrange();
        if (numrange!=null&&numrange.length()>7){
           tbNumrange.setNumrange(numrange.substring(0,7));
        }
//        String imsi = jsonObject.get("imsi").toString();
//        Short isvalid = Short.valueOf(jsonObject.get("isvalid").toString());
//        String cityname = jsonObject.get("cityname").toString();
//        String locationcode = jsonObject.get("locationcode").toString();
//        String beginno = jsonObject.get("beginno").toString();
//        String endno = jsonObject.get("endno").toString();
//        String validdate = jsonObject.get("validdate").toString();
//        String servicername = jsonObject.get("servicername").toString();
//        tbNumrange.setNumrange(phonenumber.substring(0,7));
//        tbNumrange.setProcid(imsi);
//        tbNumrange.setCityname(cityname);
//        tbNumrange.setImsi(imsi);
//        tbNumrange.setServicername(servicername);
//        tbNumrange.setIsvalid(isvalid);
//        tbNumrange.setLocationcode(locationcode);
//        tbNumrange.setValiddate(validdate);
//        tbNumrange.setBeginno(beginno);
//        tbNumrange.setEndno(endno);
        try {
            List<TBNumrange> tbNumranges = basicDataService.getBasicData(tbNumrange);
            if(tbNumranges!=null||tbNumranges.size()>0){
                ////条件查询出来的结果和pagesize放入session中
                session.setAttribute("tbNumranges",tbNumranges);
                session.setAttribute("pageSize",pageSize);
                //默认展示第一页的数据
                log.info("-------进行分页-------");
                PageHelper.startPage(1,pageSize);
                PageInfo<TBNumrange> tbNumrangePageInfo=new PageInfo<>(tbNumranges);
                map.put("pageInfo",tbNumrangePageInfo);
                map.put("status",Status.success);
                log.info("-------分页查询成功-------");
                log.info("当前页码是："+tbNumrangePageInfo.getPageNum()+"----内容总条数："+tbNumrangePageInfo.getTotal());
            }
            System.out.println(tbNumranges);
        }catch (Exception e){
            e.printStackTrace();
            log.info("查询基础号段条件出现了异常："+e.getMessage());
        }
        return map;
    }

    /**
     * 基础查询进行分页，传入页码
     * @param param
     * @param session
     * @param map
     * @return
     */
    @ApiOperation(value = "根据typecode和code获取值", notes = "根据typecode和code获取值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping("/page")
    public Map<String,Object> pageInfo(@RequestParam(value = "PARAM") String param,HttpSession session,Map<String,Object> map){
        List<TBNumrange> tbNumranges = ( List<TBNumrange>)session.getAttribute("tbNumranges");
        JSONObject jsonObject = JSONObject.parseObject(param);
        int  page = Integer.parseInt(jsonObject.get("page").toString());
        int  pageSize =(int) session.getAttribute("pageSize");
        PageHelper.startPage(page,pageSize);
        PageInfo<TBNumrange> tbNumrangePageInfo=new PageInfo<>(tbNumranges);
        log.info("当前页数："+tbNumrangePageInfo.getPageNum()+"每页条数的条数："+tbNumrangePageInfo.getPageSize());
        map.put("pageInfo",tbNumrangePageInfo);
        return map;
    }

    /**
     * 删除只是对ISVALID字段进行修改，0：失效  1：有效
     * @param param
     * @param map
     * @return
     */
    @ApiOperation(value = "根据typecode和code获取值", notes = "根据typecode和code获取值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping("/deleteById")
    public Map<String,Object> deleteById(@RequestParam(value = "PARAM") String param,Map<String,Object> map){
        JSONObject jsonObject = JSONObject.parseObject(param);
        BigDecimal id=new BigDecimal(jsonObject.get("id").toString());
        int code=basicDataService.deleteById(id);
        if(code>0){
          map.put("code",code);
          log.info("-----删除成功,删除的id为："+id);
          return map;
        }
       map.put("code",code);
        log.info("-----删除失败,id为："+id);
      return map;
    }

    @ApiOperation(value = "根据typecode和code获取值", notes = "根据typecode和code获取值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping("/updateTBNumrange")
    public Map<String,Object> updataTBNumrange(@RequestParam(value = "PARAM") String param,Map<String,Object> map){
        JSONObject jsonObject = JSONObject.parseObject(param);
        TBNumrange tbNumrange = (TBNumrange) jsonObject.get("tbNumrange");
        String numrange = tbNumrange.getNumrange();
        if (numrange!=null&&numrange.length()>7){
            tbNumrange.setNumrange(numrange.substring(0,7));
        }
        int code = basicDataService.updataTBNumrange(tbNumrange);
        if(code>0){
            map.put("code",code);
            log.info("-----修改成功,修改的id为："+tbNumrange.getId());
            return map;
        }
        map.put("code",code);
        log.info("-----修改失败,id为："+tbNumrange.getId());
        return map;
    }


    @ApiOperation(value = "根据typecode和code获取值", notes = "根据typecode和code获取值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping("/insertTBNumrange")
    public Map<String,Object> insertTBNumrange(@RequestParam(value = "PARAM") String param,Map<String,Object> map){
        JSONObject jsonObject = JSONObject.parseObject(param);
        TBNumrange tbNumrange = (TBNumrange) jsonObject.get("tbNumrange");
        String numrange = tbNumrange.getNumrange();
        if (numrange!=null&&numrange.length()>7){
            tbNumrange.setNumrange(numrange.substring(0,7));
        }
        int code = basicDataService.insertTBNumrange(tbNumrange);
        if(code>0){
            map.put("code",code);
            log.info("-----新增成功,修改的id为："+tbNumrange.getId());
            return map;
        }
        map.put("code",code);
        log.info("-----新增失败,id为："+tbNumrange.getId());
        return map;
    }
}
