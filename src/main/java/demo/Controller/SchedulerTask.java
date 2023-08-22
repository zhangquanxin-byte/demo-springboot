package demo.Controller;

import demo.service.BusinessInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Iterator;
import java.util.ServiceLoader;
import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;

@Component
@Async
public class SchedulerTask {
    private static final Logger logger = LoggerFactory.getLogger(SchedulerTask.class);

    /**
     * @Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
     * @Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
     * @Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次
     * @Scheduled(cron=""):详见cron表达式http://www.pppet.net/
     */

    //@Scheduled(fixedRate = 4000)
    public void scheduled1() {
        logger.info("=====>>>>>使用fixedRate执行定时任务");
    }
    //@Scheduled(fixedDelay = 8000)
    public void scheduled2() {
        logger.info("=====>>>>>使用fixedDelay执行定时任务");
    }

    //@Scheduled(cron="0/3 * * * * ?")
    public void scheduled3(){
        System.out.println("\"dadadada\" = " + "dadadada");
        logger.info("使用cron每隔3秒执行任务执行定时任务");

        ServiceLoader<BusinessInterface> serviceLoader  = ServiceLoader.load(BusinessInterface.class);
        //serviceLoader .forEach(BusinessInterface::dosomething);
        // 这样写的原因是，您可以一次指定这个接口的多个具体实现
        Iterator<BusinessInterface> iin= serviceLoader.iterator();
        if (iin.hasNext()) {
            BusinessInterface interfaceItem = iin.next();
            interfaceItem.dosomething("zqx");
        }
    }

}