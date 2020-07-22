package com.linghuganyu.sc.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @description TODO
 * @date 2020/7/22
 */
@Configuration
public class RibbonConfig {

    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
