package org.datausagetracing.integration.spring

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@Configuration
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Import(DataUsageTracingConfiguration::class)
@EnableWebMvc
annotation class EnableDataUsageTracing {
}