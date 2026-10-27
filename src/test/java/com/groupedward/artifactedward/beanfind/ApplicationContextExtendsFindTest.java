package com.groupedward.artifactedward.beanfind;

import com.groupedward.artifactedward.discount.DiscountPolicy;
import com.groupedward.artifactedward.discount.FixedDiscountPolicy;
import com.groupedward.artifactedward.discount.RateDiscountPolicy;
import com.groupedward.artifactedward.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Configuration
    static class TestConfig {
        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixedDiscountPolicy() {
            return new FixedDiscountPolicy();
        }
    }

    @Test
    @DisplayName("when searching with the parent type and more than two available child exist, error occurs")
    void findByParentTypeDup() {
//        DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
        assertThrows(NoUniqueBeanDefinitionException.class, () ->
            ac.getBean(DiscountPolicy.class)
        );
    }

    @Test
    @DisplayName("when searching with the parent type and more than two available child exist, state the name")
    void findByParentTypeAndName() {
        DiscountPolicy bean = ac.getBean("fixedDiscountPolicy", DiscountPolicy.class);
        assertThat(bean).isInstanceOf(FixedDiscountPolicy.class);
    }

    @Test
    @DisplayName("search with sub-type")
    void findBySubType() {
        FixedDiscountPolicy bean = ac.getBean(FixedDiscountPolicy.class);
        assertThat(bean).isInstanceOf(FixedDiscountPolicy.class);
    }

    @Test
    @DisplayName("get all beans from the parent type")
    void findAll() {
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);

        for (String beanName: beansOfType.keySet()) {
            System.out.println("beanName = " + beanName + ", object = " + beansOfType.get(beanName));
        }

        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("find by object type")
    void findByObjectType() {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);

        for (String beanName: beansOfType.keySet()) {
            System.out.println("beanName = " + beanName + ", object = " + beansOfType.get(beanName));
        }
    }
}
