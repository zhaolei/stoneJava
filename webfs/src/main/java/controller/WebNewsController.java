package org.stone.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import org.stone.dao.NativeHdfsService;
import org.stone.model.FileInfo;
import org.stone.model.Response;

@Controller
@RequestMapping("/news")
public class WebNewsController {
	
	private Log log = LogFactory.getLog(WebNewsController.class);
	
	private String tmpDir = null;
	
	public WebNewsController() {
	}


    @RequestMapping("/list")
	public ModelAndView indexPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", "msg");

		return model;
	}

    @RequestMapping("/like")
	public ModelAndView filePage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("file");
		model.addObject("msg", "msg");

		return model;
	}

    @RequestMapping("/listnews")
    public @ResponseBody
    Response list(
            @RequestParam(value = "start", required = false) String path,
            @RequestParam(value = "count", required = false) String Count)
            throws IOException {

        Response resp = new Response(200);

        List<FileInfo> files = new ArrayList<FileInfo>();
        
        this.hdfsService.listFiles(start, files, count);

        resp.setFiles(files);
        resp.setPath(path);

        return resp;

    }

}
