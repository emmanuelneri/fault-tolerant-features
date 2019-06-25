package br.com.emmanuelneri.feature.toggle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.ff4j.FF4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class FeatureToggleImpl {

    @Autowired
    private FF4j ff4j;

    @Before("@annotation(br.com.emmanuelneri.feature.toggle.FeatureToggle)")
    public void before(final JoinPoint joinPoint) {
        final Method method = getMethod(joinPoint);
        final FeatureToggle featureToggle = getFeatureToggleAnnotationFromMethod(method);

        if(!ff4j.check(featureToggle.enableKey())) {
            throw new InactiveFeatureException("Feature: inactive.");
        }
    }

    private Method getMethod(final JoinPoint joinPoint) {
        return ((MethodSignature) joinPoint.getSignature()).getMethod();
    }

    private FeatureToggle getFeatureToggleAnnotationFromMethod(final Method method) {
        return method.getDeclaredAnnotation(FeatureToggle.class);
    }

}
