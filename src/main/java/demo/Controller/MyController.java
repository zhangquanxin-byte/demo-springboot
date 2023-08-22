package demo.Controller;

import com.alibaba.fastjson.JSON;
import demo.pojo.*;
import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    //    @Resource
//    private DataSource dataSource;
    @Resource
    private UserService userService;

    @GetMapping("hello")
    public String hello() {
        return "hello, spring boot9999";
    }

   /* @GetMapping("/get")
    public String save(){
        return dataSource.toString();
    }*/

    @GetMapping("save")
    public String save() {
        JDRequest re = new JDRequest();
        ReqBodyJDMT001 reqBodyJDMT001 = new ReqBodyJDMT001();
        SyncReqHeader syncReqHeader = new SyncReqHeader();
        syncReqHeader.setDate("20201222");
        syncReqHeader.setVersion("1.0");
        BenefOwner benefOwner = new BenefOwner();
        benefOwner.setAddress("张家佃");
        benefOwner.setTelphone("15061883354");
        benefOwner.setUsername("张泉新");
        BenefOwner benefOwner1 = new BenefOwner();
        benefOwner1.setAddress("龙云堡");
        benefOwner1.setTelphone("15088888888");
        benefOwner1.setUsername("龙一");
        List<BenefOwner> list = new ArrayList<>();
        list.add(0, benefOwner);
        list.add(1, benefOwner1);
        reqBodyJDMT001.setCorpID("123");
        reqBodyJDMT001.setBenefOwners(list);
        reqBodyJDMT001.setEnterpriseName("瓜瓜");
        re.setHeader(syncReqHeader);
        re.setBody(reqBodyJDMT001);
        String s = JSON.toJSONString(re);
        System.out.println("s = " + s);
        String body = JSON.parseObject(JSON.toJSONString(re)).getString("body");
        System.out.println("body = " + body);
        User user = new User();
        user.setUsername("zhang3");
        user.setPassword("123456");
        userService.save(user);
        System.out.println("user = " + user);
        return "ok";
    }

    @PostMapping("save")
    public void save(@RequestBody JDRequest request) {
        List<BenefOwner> benefOwners = request.getBody().getBenefOwners();
        if (benefOwners == null) {
            System.out.println("benefOwners = " + benefOwners);
        } else {
            for (int i = 0; i < benefOwners.size(); i++) {
                System.out.println("benefOwners = " + benefOwners.get(i));
            }
            System.out.println("验证完成");
        }
    }

    @RequestMapping("streamFile")
    public void fileInputStream(@RequestParam("name") String name, InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("名字是：");
        sb.append(name);
        sb.append("输出流：");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        System.out.println("sb = " + sb);

    }

    @RequestMapping("multiFile")
    public String multiFile(@RequestParam("name") String name, @RequestParam("age") String age, @RequestParam("files") List<MultipartFile> multipartFiles) throws UnsupportedEncodingException {
        StringBuffer sb = new StringBuffer();
        sb.append("名字：" + name);
        sb.append("年龄：" + age);
        for (MultipartFile file : multipartFiles) {
            String filename = file.getOriginalFilename();
            if (filename == null) {
                continue;
            }
            filename=URLDecoder.decode(filename,"UTF-8");
            sb.append("文件信息：").append("文件名："+filename);
            sb.append("文件大小：").append(file.getSize()/1024).append("kb");
            sb.append("文件类型").append(file.getContentType());
        }

        System.out.println("sb = " + sb);

        return "文件传输成功！";
    }

}
