package com.github.superproxy.code.generator.core.engine.velocity;

import com.github.superproxy.code.generator.core.engine.TplModel;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import com.github.superproxy.code.generator.core.engine.TemplateEngine;

import java.io.StringWriter;
import java.util.Map;

public final class VelocityTplEngine implements TemplateEngine {

    @Override
    public void process(TplModel tplModel) {
        String tplRoot = tplModel.getTplsRoot();
        String tplPath = tplModel.getTplPath();
        String outPath = tplModel.getOutPath();
        Map<String, Object> model = tplModel.getModelMap();

        Velocity.init();

        VelocityContext context = new VelocityContext();

        for (Map.Entry<String, Object> set : model.entrySet()) {
            context.put((String) set.getKey(), set.getValue());
        }
        Template template = null;

        try {
            template = Velocity.getTemplate(tplPath);
        } catch (ResourceNotFoundException rnfe) {
            // couldn't find the template
        } catch (ParseErrorException pee) {
            // syntax error: problem parsing the template
        } catch (MethodInvocationException mie) {
            // something invoked in the template
            // threw an exception
        } catch (Exception e) {
        }

        StringWriter sw = new StringWriter();
        template.merge(context, sw);
    }

}
