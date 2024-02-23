package com.springpro.controller;

import com.springpro.entity.Task;
import com.springpro.service.TaskServiceI;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping
public class FileController {
    @Resource
    TaskServiceI serviceI;

    @RequestMapping(value = "/UploadFile")
    public String UploadFile(Integer t_id, HttpSession session) {
        session.setAttribute("t_id", t_id);
        return "UploadFile";
    }

    @RequestMapping(value="/AddFile",method = RequestMethod.POST)
    public ModelAndView Addfile(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        ModelAndView mv = new ModelAndView("MyTask");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        /**得到图片保存目录的真实路径**/
        String logoRealPathDir = request.getSession().getServletContext().getRealPath("/files");
        /**根据真实路径创建目录**/
        File logoSaveFile = new File(logoRealPathDir);
        if (!logoSaveFile.exists()) {
            logoSaveFile.mkdirs();
        }
        /**页面控件的文件流**/
        //取intro的位置
        MultipartFile multipartFile =multipartRequest.getFile("fname");
        // fname的value：文件数据包装成一个对象
            if (multipartFile.getOriginalFilename() != null && multipartFile.getOriginalFilename() != "") {
                String logImageName = multipartFile.getOriginalFilename();
                //绝对路径
                String fileName = logoRealPathDir + File.separator + logImageName;
                String fname = "/files/" + logImageName;
                //相对路径存入数据库
                File file = new File(fileName);
                Integer id = (Integer) session.getAttribute(("t_id"));
                Task task = serviceI.findTaskByTid(id);
                task.setTaskInfo(fname);
                task.setFilename(logImageName);
                try {
                    multipartFile.transferTo(file);
                    serviceI.claimTask(task);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        return mv;
    }


//    查看文件
    @RequestMapping("/showFiles")
    public ModelAndView showfiles(Integer p_id,HttpSession session){
        ModelAndView mv = new ModelAndView();
        List<Task> tasks = serviceI.TaskFile(p_id);
        if(tasks!=null&&tasks.size()!=0){
            session.setAttribute("tasks",tasks);
            mv.setViewName("showFile");
        }else {
            mv.setViewName("UserHome");
        }
        return mv;
    }

    @RequestMapping("/download")
    public void download(Integer t_id) throws IOException {
        String path = serviceI.findTaskByTid(t_id).getTaskInfo();
        File file = new File(path);
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
    }
}
