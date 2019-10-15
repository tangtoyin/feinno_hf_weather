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
     TBNumrange tbNumrange=new TBNumrange();
     JSONObject jsonObject = JSONObject.parseObject(param);
     int pageSize = Integer.parseInt(jsonObject.get("pageSize").toString());
     int pageNum=Integer.parseInt(jsonObject.get("pageNum").toString());
     String opertype=(String) jsonObject.get("opertype");
     String phonenumber=(String) jsonObject.get("phonenum");
     String imsi = jsonObject.get("imsi").toString();
     Short isvalid = Short.valueOf(jsonObject.get("isvalid").toString());
     String cityname = jsonObject.get("cityname").toString();
     String locationcode = jsonObject.get("locationcode").toString();
     String servicername = jsonObject.get("servicername").toString();
     tbNumrange.setNumrange(phonenumber);
     tbNumrange.setCityname(cityname);
     tbNumrange.setImsi(imsi);
     tbNumrange.setServicername(servicername);
     tbNumrange.setIsvalid(isvalid);
     tbNumrange.setLocationcode(locationcode);
     tbNumrange.setOpertype(opertype);
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
    @RequestMapping("/delete")
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
    @RequestMapping("/update")
    public Map<String,Object> updataTBNumrange(@RequestParam(value = "PARAM") String param,Map<String,Object> map){
        TBNumrange tbNumrange=new TBNumrange();
        JSONObject jsonObject = JSONObject.parseObject(param);
        String phonenumber=(String) jsonObject.get("phonenum");
        String imsi = jsonObject.get("imsi").toString();
        Short isvalid = Short.valueOf(jsonObject.get("isvalid").toString());
        String cityname = jsonObject.get("cityname").toString();
        String locationcode = jsonObject.get("locationcode").toString();
        String beginno = jsonObject.get("beginno").toString();
        String endno = jsonObject.get("endno").toString();
        String validdate = jsonObject.get("validdate").toString();
        String expiprdate=jsonObject.get("expiprdate").toString();
        String type=jsonObject.get("type").toString();
        String classify=jsonObject.get("classify").toString();
        tbNumrange.setClassify(classify);
        tbNumrange.setType(type);
        tbNumrange.setExpiprdate(expiprdate);
        tbNumrange.setNumrange(phonenumber);
        tbNumrange.setCityname(cityname);
        tbNumrange.setImsi(imsi);
        tbNumrange.setIsvalid(isvalid);
        tbNumrange.setLocationcode(locationcode);
        tbNumrange.setValiddate(validdate);
        tbNumrange.setBeginno(beginno);
        tbNumrange.setEndno(endno);
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
    @RequestMapping("/insert")
    public Map<String,Object> insertTBNumrange(@RequestParam(value = "PARAM") String param,Map<String,Object> map){
        TBNumrange tbNumrange=new TBNumrange();
        JSONObject jsonObject = JSONObject.parseObject(param);
        String phonenumber=(String) jsonObject.get("phonenum");
        String imsi = jsonObject.get("imsi").toString();
        Short isvalid = Short.valueOf(jsonObject.get("isvalid").toString());
        String cityname = jsonObject.get("cityname").toString();
        String locationcode = jsonObject.get("locationcode").toString();
        String beginno = jsonObject.get("beginno").toString();
        String endno = jsonObject.get("endno").toString();
        String validdate = jsonObject.get("validdate").toString();
        String expiprdate=jsonObject.get("expiprdate").toString();
        String type=jsonObject.get("type").toString();
        String classify=jsonObject.get("classify").toString();
        tbNumrange.setClassify(classify);
        tbNumrange.setType(type);
        tbNumrange.setExpiprdate(expiprdate);
        tbNumrange.setNumrange(phonenumber.substring(0,7));
        tbNumrange.setCityname(cityname);
        tbNumrange.setImsi(imsi);
        tbNumrange.setIsvalid(isvalid);
        tbNumrange.setLocationcode(locationcode);
        tbNumrange.setValiddate(validdate);
        tbNumrange.setBeginno(beginno);
        tbNumrange.setEndno(endno);
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

    /**
     * 长途区号查询
     * @param param
     * @param session
     * @return
     */
    @ApiOperation(value = "根据typecode和code获取值", notes = "根据typecode和code获取值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/detailLong", method = RequestMethod.POST)
    public Map<String ,Object> selectByTBLongareacode(@RequestParam(value = "PARAM") String param, HttpSession session){
        Map<String,Object> map=new HashMap<>();
        TBLongareacode tbLongareacode=new TBLongareacode();
        JSONObject jsonObject = JSONObject.parseObject(param);
        int pageSize = Integer.parseInt(jsonObject.get("pageSize").toString());
        int pageNum=Integer.parseInt(jsonObject.get("pageNum").toString());
        String procid=(String) jsonObject.get("procid");
        String opertype = jsonObject.get("opertype").toString();
        String areacode = jsonObject.get("areacode").toString();
        String provcode = jsonObject.get("provcode").toString();
        String areaname = jsonObject.get("areaname").toString();
        String validdate = jsonObject.get("validdate").toString();
        Short isvalid = Short.valueOf(jsonObject.get("isvalid").toString());
        String locationcode = jsonObject.get("locationcode").toString();
        tbLongareacode.setAreacode(areacode);
        tbLongareacode.setAreaname(areaname);
        tbLongareacode.setIsvalid(isvalid);
        tbLongareacode.setLocationcode(locationcode);
        tbLongareacode.setOpertype(opertype);
        tbLongareacode.setValiddate(validdate);
        tbLongareacode.setProvcode(provcode);
        tbLongareacode.setProcid(procid);
        try {
            List<TBLongareacode> tbLongareacodes = basicDataService.selectByTBLongareacode(tbLongareacode);
            if(tbLongareacodes!=null||tbLongareacodes.size()>0){
                ////条件查询出来的结果和pagesize放入session中
                session.setAttribute("tbLongareacodes",tbLongareacodes);
                session.setAttribute("pageSizeLong",pageSize);
                //默认展示第一页的数据
                log.info("-------进行分页-------");
                PageHelper.startPage(1,pageSize);
                PageInfo<TBLongareacode> tbLongareacodePageInfo=new PageInfo<>(tbLongareacodes);
                map.put("pageInfo",tbLongareacodePageInfo);
                map.put("status",Status.success);
                log.info("-------分页查询成功-------");
                log.info("当前页码是："+tbLongareacodePageInfo.getPageNum()+"----内容总条数："+tbLongareacodePageInfo.getTotal());
            }
            System.out.println(tbLongareacodes);
        }catch (Exception e){
            e.printStackTrace();
            log.info("查询基础号段条件出现了异常："+e.getMessage());
        }
        return map;
    }

    @RequestMapping("/pageLong")
    public Map<String,Object> pageInfolong(@RequestParam(value = "PARAM") String param,HttpSession session,Map<String,Object> map){
        List<TBLongareacode> tbLongareacodes = ( List<TBLongareacode>)session.getAttribute("tbLongareacodes");
        JSONObject jsonObject = JSONObject.parseObject(param);
        int  page = Integer.parseInt(jsonObject.get("page").toString());
        int  pageSize =(int) session.getAttribute("pageSizeLong");
        PageHelper.startPage(page,pageSize);
        PageInfo<TBLongareacode> tbLongareacodePageInfo=new PageInfo<>(tbLongareacodes);
        log.info("当前页数："+tbLongareacodePageInfo.getPageNum()+"每页条数的条数："+tbLongareacodePageInfo.getPageSize());
        map.put("pageInfo",tbLongareacodePageInfo);
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

    @RequestMapping("/deleteLong")
    public Map<String,Object> deleteByIdTBLongareacode(@RequestParam(value = "PARAM") String param,Map<String,Object> map){
        JSONObject jsonObject = JSONObject.parseObject(param);
        BigDecimal id=new BigDecimal(jsonObject.get("id").toString());
        int code=basicDataService.deleteByTBLongareacodeId(id);
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
    @RequestMapping("/updateLong")
    public Map<String,Object> update(@RequestParam(value = "PARAM") String param,Map<String,Object> map){
        TBLongareacode tbLongareacode=new TBLongareacode();
        JSONObject jsonObject = JSONObject.parseObject(param);
        String opertype = jsonObject.get("opertype").toString();
        String areacode = jsonObject.get("areacode").toString();
        String provcode = jsonObject.get("provcode").toString();
        String areaname = jsonObject.get("areaname").toString();
        String validdate = jsonObject.get("validdate").toString();
        Short isvalid = Short.valueOf(jsonObject.get("isvalid").toString());
        String locationcode = jsonObject.get("locationcode").toString();
        String expiprdate=jsonObject.getString("expiprdate").toString();
        tbLongareacode.setExpiredate(expiprdate);
        tbLongareacode.setAreacode(areacode);
        tbLongareacode.setAreaname(areaname);
        tbLongareacode.setIsvalid(isvalid);
        tbLongareacode.setLocationcode(locationcode);
        tbLongareacode.setOpertype(opertype);
        tbLongareacode.setValiddate(validdate);
        tbLongareacode.setProvcode(provcode);
        int code = basicDataService.updataTBLongareacode(tbLongareacode);
        if(code>0){
            map.put("code",code);
            log.info("-----修改成功,修改的id为："+tbLongareacode.getId());
            return map;
        }
        map.put("code",code);
        log.info("-----修改失败,id为："+tbLongareacode.getId());
        return map;
    }

    @ApiOperation(value = "根据typecode和code获取值", notes = "根据typecode和code获取值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appcode", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ts", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "rnd", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "sig", dataType = "String", paramType = "query"),
    })
    @RequestMapping("/insertLong")
    public Map<String,Object> insertTBLongareacode(@RequestParam(value = "PARAM") String param,Map<String,Object> map){
        TBLongareacode tbLongareacode=new TBLongareacode();
        JSONObject jsonObject = JSONObject.parseObject(param);
        String opertype = jsonObject.get("opertype").toString();
        String areacode = jsonObject.get("areacode").toString();
        String provcode = jsonObject.get("provcode").toString();
        String areaname = jsonObject.get("areaname").toString();
        String validdate = jsonObject.get("validdate").toString();
        Short isvalid = Short.valueOf(jsonObject.get("isvalid").toString());
        String locationcode = jsonObject.get("locationcode").toString();
        String expiprdate=jsonObject.getString("expiprdate").toString();
        tbLongareacode.setExpiredate(expiprdate);
        tbLongareacode.setAreacode(areacode);
        tbLongareacode.setAreaname(areaname);
        tbLongareacode.setIsvalid(isvalid);
        tbLongareacode.setLocationcode(locationcode);
        tbLongareacode.setOpertype(opertype);
        tbLongareacode.setValiddate(validdate);
        tbLongareacode.setProvcode(provcode);
        int code = basicDataService.insertByTBLongareacode(tbLongareacode);
        if(code>0){
            map.put("code",code);
            log.info("-----新增成功,修改的id为："+tbLongareacode.getId());
            return map;
        }
        map.put("code",code);
        log.info("-----新增失败,id为："+tbLongareacode.getId());
        return map;
    }


}
