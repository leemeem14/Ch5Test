package kr.ac.kopo.lyh.ch5test.Controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.util.MultiValueMap;


@Controller
public class Example01Controller {
    @GetMapping("/exam01")
    public String requestMethod(@RequestParam("id") String userId,@RequestParam("passwd")String userPw, Model model) {
        model.addAttribute("data1","@RequesrParam연습");
        model.addAttribute("data2","요청파라미터에 전달된 id값 :"+ userId + "<br>PW는" + userPw);
        return "viewPage";
    }
    @GetMapping("/exam02")
    public String requestMethod2(@RequestParam(value = "id", defaultValue = "Anonymous") String userId,@RequestParam("passwd")String userPw, Model model) {
        model.addAttribute("data1","@RequesrParam연습");
        model.addAttribute("data2","요청파라미터에 전달된 id값 :"+ userId + "<br>PW는" + userPw);
        return "viewPage";
    }
    @GetMapping("/exam03/{id}")
    public String requestMethod3(@PathVariable("id") String userId, Model model) {
        model.addAttribute("data1","@RequesrParam연습");
        model.addAttribute("data2","요청파라미터에 전달된 id값 :"+ userId);
        return "viewPage";
    }
    @GetMapping("/exam04/{id}/{passwd}")
    public String requestMethod4(@PathVariable("id") String userId,@PathVariable("passwd") String userPw, Model model) {
        model.addAttribute("data1","@RequesrParam연습");
        model.addAttribute("data2","요청파라미터에 전달된 id값 :"+ userId+ "<br>PW는" + userPw);
        return "viewPage";
    }
    @GetMapping("/exam05/{id}")
    public String requestMethod5(@PathVariable("id") String userId,@MatrixVariable("passwd")String userPw, Model model) {
        model.addAttribute("data1","@RequesrParam연습");
        model.addAttribute("data2","요청파라미터에 전달된 id값 :"+ userId+ "<br>매트릭스변수 PW : " + userPw);
        return "viewPage";
    }
    @GetMapping("/exam06/{id1}/user/{id2}")
    public String requestMethod6(@PathVariable("id1") String userId1,@MatrixVariable(value = "passwd",pathVar = "id1")String userPw1,
                                 @PathVariable("id2") String userId2,@MatrixVariable(value = "passwd",pathVar = "id2")String userPw2 ,
                                 Model model)
    {
        model.addAttribute("data1","@MatrixVariable 연습");
        model.addAttribute("data2","경로 변수 id1값 : "+ userId1 + "매트릭스 변수 passwd1값 : "+ userPw1 +
                                       "<br>경로 변수 id2값 : "+ userId2 + "매트릭스 변수 passwd2값 : "+ userPw2);
        return "viewPage";
    }
    @GetMapping("/exam07/{id}")
    public String requestMethod7(@PathVariable("id") String userId,@MatrixVariable(value = "passwd",defaultValue = "bruh201")String userPw, Model model) {
        model.addAttribute("data1","@RequestParam연습");
        model.addAttribute("data2","요청파라미터에 전달된 id값 : "+ userId+ "<br>매트릭스변수 PW : " + userPw);
        return "viewPage";
    }
    @GetMapping("/exam08/{id1}/user/{id2}")
    public String requestMethod8(@MatrixVariable MultiValueMap<String, String> var1,
                                 @MatrixVariable(pathVar = "id2") MultiValueMap<String, String> var2,
                                 Model model)
    {
        model.addAttribute("data1","@MatrixVariable 연습");
        model.addAttribute("data2", var1 + "<p>"+ var2);
        return "viewPage";
    }
}
