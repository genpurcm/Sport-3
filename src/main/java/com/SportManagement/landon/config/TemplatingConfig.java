package com.SportManagement.landon.config;


//import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;


@Configuration

//public class TemplatingConfig implements ApplicationContextAware {
public class TemplatingConfig {

//    private ApplicationContext applicationContext;
//
//    @Override
//    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException
//    {
//        this.applicationContext = applicationContext;
//    }
//    @Bean
////    public TemplateEngine templateEngine() {
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine engine = new SpringTemplateEngine();
//        engine.addTemplateResolver(templateResolverPublic());
//        engine.addTemplateResolver(templateResolverTemplates());
//        return engine;
//    }
    @Bean
    public ITemplateResolver templateResolverPublic() {
//    public SpringResourceTemplateResolver templateResolverPublic() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//        resolver.setApplicationContext(this.applicationContext);
        resolver.setPrefix("classpath:/static/");
        resolver.setSuffix(".html");
        // Template Mode HTML5 deprecated, use HTML instead.
//        resolver.setTemplateMode("HTML5");
        resolver.setTemplateMode("HTML");
        resolver.setCacheable(false);
        resolver.setOrder(0);
        resolver.setCheckExistence(true);
        return resolver;
    }
    @Bean
    public ITemplateResolver templateResolverTemplates() {
//    public SpringResourceTemplateResolver templateResolverTemplates() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//        resolver.setApplicationContext(this.applicationContext);
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");
        // Template Mode HTML5 deprecated, use HTML instead.
//        resolver.setTemplateMode("HTML5");
        resolver.setTemplateMode("HTML");
        resolver.setCacheable(false);
        resolver.setOrder(0);
        resolver.setCheckExistence(true);
        return resolver;
    }



//    @Bean
//    public ITemplateResolver templateResolver() {
//        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//        resolver.setPrefix("classpath:/static/");
//        // For Spring Boot
//        // resolver.setPrefix("classpath:/templates/");
//        resolver.setSuffix(".html");
//        resolver.setOrder(0);
////        resolver.setTemplateMode(TemplateMode.html);
//        resolver.setTemplateMode("HTML5");
//        resolver.setCacheable(false);
//        return resolver;
//    }
}