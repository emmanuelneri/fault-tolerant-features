package br.com.emmanuelneri.feature.toggle.impl;

import br.com.emmanuelneri.feature.toggle.FeatureToggle;
import br.com.emmanuelneri.feature.toggle.Features;
import br.com.emmanuelneri.feature.toggle.exceptions.InactiveFeatureException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.togglz.core.manager.FeatureManager;

import java.lang.reflect.Method;

@Aspect
@Component
public class FeatureToggleImpl {

    @Autowired
    private Environment environment;

    @Autowired
    private FeatureManager featureManager;

    @Before("@annotation(br.com.emmanuelneri.feature.toggle.FeatureToggle)")
    public void before(final JoinPoint joinPoint) {
        final Method method = getMethod(joinPoint);
        final FeatureToggle featureToggle = getFeatureToggleAnnotationFromMethod(method);

        final Features feature = featureToggle.feature();
        final boolean isFeatureEnable = featureManager.isActive(feature);

        if(!isFeatureEnable) {
            throw new InactiveFeatureException("Features: " + feature.getName() + " inactive.");
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
