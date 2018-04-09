package com.jianchi.html;

import com.jianchi.service.BucketHeaderService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fulushou on 2018/4/8.
 */
@Service(value = "generate")
public class Generate {

    @Autowired
    BucketHeaderService bucketHeaderService ;

    public void toGenerateHTml() throws Exception{
   /* ------------------------------------------------------------------------ */
        /* You should do this ONLY ONCE in the whole application life-cycle:        */

        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setDirectoryForTemplateLoading(new File(getClass().getResource("/").getFile()));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        /* ------------------------------------------------------------------------ */
        /* You usually do these for MULTIPLE TIMES in the application life-cycle:   */

        /* Create a data-model */
      /*  Map root = new HashMap();
        root.put("user", "Big Joe");
        Map latest = new HashMap();
        root.put("latestProduct", latest);
        latest.put("url", "products/greenmouse.html");
        latest.put("name", "green mouse");*/

        Map<String,Object> map = new HashMap();
        map.put("headers",bucketHeaderService.getBucketTableHeaderMap());

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate("form.ftl");

        OutputStream outputStreamWriter = new FileOutputStream("aa/form.ftl");
        /* Merge data-model with template */
        Writer out = new OutputStreamWriter(outputStreamWriter);
        temp.process(map, out);
        // Note: Depending on what `out` is, you may need to call `out.close()`.
        // This is usually the case for file output, but not for servlet output.
    }

}
