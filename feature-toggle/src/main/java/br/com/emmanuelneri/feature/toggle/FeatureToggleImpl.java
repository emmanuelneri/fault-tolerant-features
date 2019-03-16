package br.com.emmanuelneri.feature.toggle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class FeatureToggleImpl {

    @Autowired
    private Environment environment;

    @Before("@annotation(br.com.emmanuelneri.feature.toggle.FeatureToggle)")
    public void before(final JoinPoint joinPoint) {
        final Method method = getMethod(joinPoint);
        final FeatureToggle featureToggle = getFeatureToggleAnnotationFromMethod(method);

        final boolean isFeatureEnable = Boolean.valueOf(getEnvironmentProperty(featureToggle.enableKey()));
        final String featureName = getEnvironmentProperty(featureToggle.nameKey());

        if(!isFeatureEnable) {
            throw new InactiveFeatureException("Feature: " + featureName + " inactive.");
        }
    }

    private String getEnvironmentProperty(final String property) {
        return environment.getProperty(property);
    }

    private Method getMethod(final JoinPoint joinPoint) {
        return ((MethodSignature) joinPoint.getSignature()).getMethod();
    }

    private FeatureToggle getFeatureToggleAnnotationFromMethod(final Method method) {
        return method.getDeclaredAnnotation(FeatureToggle.class);
    }

}
