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

        final boolean isFeatureEnable = Boolean.valueOf(environment.getProperty(featureToggle.enableKey()));
        final String featureName = environment.getProperty(featureToggle.nameKey());

        if(!isFeatureEnable) {
            throw new InactiveFeatureException("Feature: " + featureName + " inactive.");
        }
    }

    private Method getMethod(final JoinPoint joinPoint) {
        final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        return methodSignature.getMethod();
    }

    private FeatureToggle getFeatureToggleAnnotationFromMethod(final Method method) {
        return method.getDeclaredAnnotation(FeatureToggle.class);
    }

}
