package automationFramework.SeleniumBasics;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.ReCaptcha;

public class SeleniumCaptchaBypass 
{
	public static void main(String[] args) {
        TwoCaptcha solver = new TwoCaptcha("YOUR_API_KEY"); //To get API key, needs to register https://2captcha.com/ (paid captcha recognition service)
        ReCaptcha captcha = new ReCaptcha();
        captcha.setSiteKey("6LeIxboZAAAAAFQy7d8GPzgRZu2bV0GwKS8ue_cH");
        captcha.setUrl("https://2captcha.com/demo/recaptcha-v2");
        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
