package com.product.controller;

import com.github.pagehelper.PageInfo;
import com.product.service.LiveService;
import com.product.util.CodeMakeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 住宿管理功能
 */
@Controller
@RequestMapping("/live")
public class LiveController {
    @Resource
    private LiveService liveService;




    /**--------------------------------校区管理 start----------------------------------------*/

    /**
     * 添加校区
     * name  校区名称
     */
    @RequestMapping("/AddCampus")
    @ResponseBody
    public Map<String,Object> AddCampus(HttpServletRequest request){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String created_time = sdf.format(date);
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String name = request.getParameter("name");
            param.put("rksj",created_time);
            param.put("name",name);
            liveService.AddCampus(param);
            result.put("data",null);
            result.put("message","校区添加成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","校区添加失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 修改校区
     * name  校区名称
     * id
     */
    @RequestMapping("/EditCampus")
    @ResponseBody
    public Map<String,Object> EditCampus(HttpServletRequest request){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String created_time = sdf.format(date);
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String name = request.getParameter("name");
            String id = request.getParameter("id");
            param.put("rksj",created_time);
            param.put("id",id);
            param.put("name",name);
            liveService.EditCampus(param);
            result.put("data",null);
            result.put("message","校区修改成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","校区修改失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 删除校区
     * id
     */
    @RequestMapping("/DeleteCampus")
    @ResponseBody
    public Map<String,Object> DeleteCampus(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String id = request.getParameter("id");
            param.put("id",id);
            liveService.DeleteCampus(param);
            result.put("data",null);
            result.put("message","校区删除成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","校区删除失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 是否存在公寓
     * 本校区下是否存在公寓区
     * bh  校区编号
     */
    @RequestMapping("/ExistApartment")
    @ResponseBody
    public Map<String,Object> ExistApartment(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String bh = request.getParameter("bh");
            param.put("bh",bh);
            result.put("data",liveService.ExistApartment(param));
            result.put("message","是否存在公寓查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","是否存在公寓查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 校区列表
     * pageNum
     * pageSize
     */
    @RequestMapping("/QueryCampusList")
    @ResponseBody
    public Map<String,Object> QueryUserList(HttpServletRequest request,int pageNum,int pageSize){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        List<Map<String,Object>> list=new ArrayList<>();
        try{
            list = liveService.QueryCampusList(param,pageNum,pageSize);
            PageInfo<Map<String,Object>> pageList = new PageInfo<>(list);
            result.put("data",pageList);
            result.put("message","校区列表查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","校区列表查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**--------------------------------校区管理 end----------------------------------------*/


    /**--------------------------------公寓区管理 start----------------------------------------*/
    /**
     * 公寓区列表
     * pageNum
     * pageSize
     * xqbh  校区编号（可以为空）
     */
    @RequestMapping("/QueryApartmentList")
    @ResponseBody
    public Map<String,Object> QueryApartmentList(HttpServletRequest request,int pageNum,int pageSize){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        List<Map<String,Object>> list=new ArrayList<>();
        try{
            String xqbh =request.getParameter("xqbh");
            param.put("xqbh",xqbh);
            list = liveService.QueryApartmentList(param,pageNum,pageSize);
            PageInfo<Map<String,Object>> pageList = new PageInfo<>(list);
            result.put("data",pageList);
            result.put("message","公寓区列表查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","公寓区列表查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 新增公寓区
     * name  校区名称
     * xqbh  校区编号
     */
    @RequestMapping("/AddApartment")
    @ResponseBody
    public Map<String,Object> AddApartment(HttpServletRequest request){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String created_time = sdf.format(date);
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String name = request.getParameter("name");
            String xqbh = request.getParameter("xqbh");
            param.put("rksj",created_time);
            param.put("name",name);
            param.put("xqbh",xqbh);
            liveService.AddApartment(param);
            result.put("data",null);
            result.put("message","公寓区添加成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","公寓区添加失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 修改公寓区
     * name  校区名称
     * id
     * 只允许修改公寓区名字，不允许修改学校区，bh已经生成，下级无法自动更改关联所属关系
     */
    @RequestMapping("/EditApartment")
    @ResponseBody
    public Map<String,Object> EditApartment(HttpServletRequest request){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String created_time = sdf.format(date);
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String name = request.getParameter("name");
            String id = request.getParameter("id");
            param.put("rksj",created_time);
            param.put("id",id);
            param.put("name",name);
            liveService.EditApartment(param);
            result.put("data",null);
            result.put("message","公寓区修改成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","公寓区修改失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 删除公寓区
     * id
     */
    @RequestMapping("/DeleteApartment")
    @ResponseBody
    public Map<String,Object> DeleteApartment(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String id = request.getParameter("id");
            param.put("id",id);
            liveService.DeleteApartment(param);
            result.put("data",null);
            result.put("message","公寓区删除成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","公寓区删除失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 是否存在楼
     * 公寓区下是否存在楼
     * gybh  公寓编号
     */
    @RequestMapping("/ExistFloor")
    @ResponseBody
    public Map<String,Object> ExistFloor(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String gybh = request.getParameter("gybh");
            param.put("gybh",gybh);
            result.put("data",liveService.ExistFloor(param));
            result.put("message","是否存在楼查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","是否存在楼查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**--------------------------------公寓区管理 end----------------------------------------*/




    /**--------------------------------楼管理 start----------------------------------------*/

    /**
     * 楼列表
     * pageNum
     * pageSize
     * xqbh  校区编号（可以为空）
     * gybh  公寓编号（可以为空）
     */
    @RequestMapping("/QueryFloorList")
    @ResponseBody
    public Map<String,Object> QueryFloorList(HttpServletRequest request,int pageNum,int pageSize){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        List<Map<String,Object>> list=new ArrayList<>();
        try{
            String xqbh =request.getParameter("xqbh");
            String gybh =request.getParameter("gybh");
            param.put("xqbh",xqbh);
            param.put("gybh",gybh);
            list = liveService.QueryFloorList(param,pageNum,pageSize);
            PageInfo<Map<String,Object>> pageList = new PageInfo<>(list);
            result.put("data",pageList);
            result.put("message","公寓区列表查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","公寓区列表查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 新增楼
     * name  楼名
     * louzt  楼状态
     * xqbh  校区编号
     * gybh  公寓编号
     */
    @RequestMapping("/AddFloor")
    @ResponseBody
    public Map<String,Object> AddFloor(HttpServletRequest request){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String created_time = sdf.format(date);
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String name = request.getParameter("name");
            String louzt = request.getParameter("louzt");
            String xqbh = request.getParameter("xqbh");
            String gybh = request.getParameter("gybh");
            param.put("rksj",created_time);
            param.put("name",name);
            param.put("louzt",louzt);
            param.put("xqbh",xqbh);
            param.put("gybh",gybh);
            liveService.AddFloor(param);
            result.put("data",null);
            result.put("message","楼添加成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","楼添加失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 修改楼
     * name  楼名称
     * id
     * 只允许修改楼名字，不允许修改学校区，bh已经生成，下级无法自动更改关联所属关系
     */
    @RequestMapping("/EditFloor")
    @ResponseBody
    public Map<String,Object> EditFloor(HttpServletRequest request){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String created_time = sdf.format(date);
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String name = request.getParameter("name");
            String id = request.getParameter("id");
            param.put("rksj",created_time);
            param.put("id",id);
            param.put("name",name);
            liveService.EditFloor(param);
            result.put("data",null);
            result.put("message","楼修改成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","楼修改失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 删除楼栋
     * id
     */
    @RequestMapping("/DelFloor")
    @ResponseBody
    public Map<String,Object> DelFloor(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String id = request.getParameter("id");
            param.put("id",id);
            liveService.DelFloor(param);
            result.put("data",null);
            result.put("message","停用楼操作成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","停用楼操作失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 该楼下床位是否都是空置或者停用状态（没有入住状态）
     * 是否存在正在使用床位
     * 楼  loubh
     * data结果大于0，表示是有入住状态的床位，不允许删除
     */
    @RequestMapping("/ExistBedZtLou")
    @ResponseBody
    public Map<String,Object> ExistBedZtLou(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String loubh = request.getParameter("loubh");
            param.put("loubh",loubh);
            result.put("data",liveService.ExistBedZtLou(param));
            result.put("message","是否存在正在使用床位查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","是否存在正在使用床位查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**--------------------------------楼管理 end----------------------------------------*/


    /**--------------------------------房间管理 start----------------------------------------*/
    /**
     * 房间列表
     * pageNum
     * pageSize
     * xqbh  校区编号（可以为空）
     * gybh  公寓编号（可以为空）
     * loubh 楼编号（可以为空）
     * fjbh 房间编号（可以为空）
     */
    @RequestMapping("/QueryRoomList")
    @ResponseBody
    public Map<String,Object> QueryRoomList(HttpServletRequest request,int pageNum,int pageSize){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        List<Map<String,Object>> list=new ArrayList<>();
        try{
            String xqbh =request.getParameter("xqbh");
            String gybh =request.getParameter("gybh");
            String loubh =request.getParameter("loubh");
            String fjbh =request.getParameter("fjbh");
            param.put("xqbh",xqbh);
            param.put("gybh",gybh);
            param.put("loubh",loubh);
            param.put("fjbh",fjbh);
            list = liveService.QueryRoomList(param,pageNum,pageSize);
            PageInfo<Map<String,Object>> pageList = new PageInfo<>(list);
            result.put("data",pageList);
            result.put("message","房间列表查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","房间列表查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 新增房间
     * 注：按顺序选择校区，公寓，楼之后才允许输入房间编号
     * xqbh  校区编号
     * gybh  公寓编号
     * loubh 楼编号
     * fjbh  房间编号（房间编号输入完就应该检测房间编号是否重复）
     * fjbz  房间标准
     * louzt  楼的状态
     */
    @RequestMapping("/AddRoom")
    @ResponseBody
    public Map<String,Object> AddRoom(HttpServletRequest request){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String created_time = sdf.format(date);
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String xqbh = request.getParameter("xqbh");
            String gybh = request.getParameter("gybh");
            String loubh = request.getParameter("loubh");
            String fjbh = request.getParameter("fjbh");
            String fjbz = request.getParameter("fjbz");
            String louzt = request.getParameter("louzt");
            param.put("rksj",created_time);
            param.put("xqbh",xqbh);
            param.put("gybh",gybh);
            param.put("loubh",loubh);
            param.put("fjbh",fjbh);
            param.put("fjbz",fjbz);
            param.put("bh",xqbh+gybh+loubh+fjbh);
            param.put("louzt",louzt);
            liveService.AddRoom(param);
            result.put("data",null);
            result.put("message","房间添加成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","房间添加失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 判断是否存在重复房间
     * loubh 楼编号
     * fjbh  房间编号
     */
    @RequestMapping("/repeatRoom")
    @ResponseBody
    public Map<String,Object> repeatRoom(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String loubh = request.getParameter("loubh");
            String fjbh = request.getParameter("fjbh");
            param.put("loubh",loubh);
            param.put("fjbh",fjbh);
            result.put("data",liveService.repeatRoom(param));
            result.put("message","判断是否存在重复房间查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","判断是否存在重复房间查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 判断该楼该房间下床位是否都是空置或者停用状态（没有入住状态）
     * 房间编号 fjbh
     * 楼  loubh
     * data结果大于0，表示是有入住状态的床位，不允许修改
     */
    @RequestMapping("/ExistRoomRz")
    @ResponseBody
    public Map<String,Object> ExistRoomRz(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String loubh = request.getParameter("loubh");
            String fjbh = request.getParameter("fjbh");
            param.put("loubh",loubh);
            param.put("fjbh",fjbh);
            result.put("data",liveService.ExistRoomRz(param));
            result.put("message","判断该楼该房间下床位是否都是空置或者停用状态查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","判断该楼该房间下床位是否都是空置或者停用状态查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 修改房间 ---可以修改房间标准
     * xqbh  校区编号
     * gybh  公寓编号
     * loubh 楼编号
     * fjbh  房间编号（房间编号输入完就应该检测房间编号是否重复）
     * fjbz  房间标准
     * louzt  楼的状态
     */
    @RequestMapping("/EditRoom")
    @ResponseBody
    public Map<String,Object> EditRoom(HttpServletRequest request){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String created_time = sdf.format(date);
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String xqbh = request.getParameter("xqbh");
            String gybh = request.getParameter("gybh");
            String loubh = request.getParameter("loubh");
            String fjbh = request.getParameter("fjbh");
            String fjbz = request.getParameter("fjbz");
            String louzt = request.getParameter("louzt");
            param.put("rksj",created_time);
            param.put("xqbh",xqbh);
            param.put("gybh",gybh);
            param.put("loubh",loubh);
            param.put("fjbh",fjbh);
            param.put("fjbz",fjbz);
            param.put("bh",xqbh+gybh+loubh+fjbh);
            param.put("louzt",louzt);
            liveService.EditRoom(param);
            result.put("data",null);
            result.put("message","楼修改成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","楼修改失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 删除房间
     * loubh 楼编号
     * fjbh  房间编号
     */
    @RequestMapping("/DelRoom")
    @ResponseBody
    public Map<String,Object> DelRoom(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String loubh = request.getParameter("loubh");
            String fjbh = request.getParameter("fjbh");
            param.put("loubh",loubh);
            param.put("fjbh",fjbh);
            liveService.DelRoom(param);
            result.put("data",null);
            result.put("message","停用楼操作成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","停用楼操作失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 停用房间/启用房间
     * fjbh 房间编号
     * loubh 楼编号
     * zt (1----启用  3---禁用)
     */
    @RequestMapping("/StopRoom")
    @ResponseBody
    public Map<String,Object> StopRoom(HttpServletRequest request){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String created_time = sdf.format(date);
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String loubh = request.getParameter("loubh");
            String fjbh = request.getParameter("fjbh");
            String zt = request.getParameter("zt");
            param.put("loubh",loubh);
            param.put("fjbh",fjbh);
            param.put("zt",zt);
            param.put("rksj",created_time);
            liveService.StopRoom(param);
            result.put("data",null);
            result.put("message","停用楼操作成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","停用楼操作失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**--------------------------------房间管理 end----------------------------------------*/
}
