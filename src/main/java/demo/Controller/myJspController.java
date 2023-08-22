package demo.Controller;

import com.zqx.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("jsp")
public class myJspController {

    @Resource
    private DemoService demoService;

    @RequestMapping("/get")
    public String getJsp(HttpServletRequest request){
        request.setAttribute("demo",demoService.get());
        return "index";
    }
}
