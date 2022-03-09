package cn.iocoder.yudao.module.tool.service.codegen.template;

import cn.hutool.core.map.MapUtil;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Hobo
 * @date 2022/3/4
 */
public class OneToOneCodegenTemplate {

    private static final String FILE_PATH_PREFIX = "codegen";

    /**
     * 模板配置
     * key：模板在 resources 的地址
     * value：生成的路径
     */
    public static final Map<String, String> MAP = MapUtil.<String, String>builder(new LinkedHashMap<>()) // 有序
            // Java module-impl Main
            .put(javaTemplatePath("controller/vo/baseVO"), javaModuleImplVOFilePath("BaseVO"))
            .put(javaTemplatePath("controller/vo/createReqVO"), javaModuleImplVOFilePath("CreateReqVO"))
            .put(javaTemplatePath("controller/vo/pageReqVO"), javaModuleImplVOFilePath("PageReqVO"))
            .put(javaTemplatePath("controller/vo/respVO"), javaModuleImplVOFilePath("RespVO"))
            .put(javaTemplatePath("controller/vo/updateReqVO"), javaModuleImplVOFilePath("UpdateReqVO"))
            .put(javaTemplatePath("controller/vo/exportReqVO"), javaModuleImplVOFilePath("ExportReqVO"))
            .put(javaTemplatePath("controller/vo/excelVO"), javaModuleImplVOFilePath("ExcelVO"))
            .put(javaTemplatePath("controller/controller"), javaModuleImplControllerFilePath())
            .put(javaTemplatePath("convert/convert"),
                    javaModuleImplMainFilePath("convert/${table.businessName}/${table.className}Convert"))
            .put(javaTemplatePath("dal/do"),
                    javaModuleImplMainFilePath("dal/dataobject/${table.businessName}/${table.className}DO"))
            .put(javaTemplatePath("dal/mapper"),
                    javaModuleImplMainFilePath("dal/mysql/${table.businessName}/${table.className}Mapper"))
            .put(javaTemplatePath("service/serviceImpl"),
                    javaModuleImplMainFilePath("service/${table.businessName}/${table.className}ServiceImpl"))
            .put(javaTemplatePath("service/service"),
                    javaModuleImplMainFilePath("service/${table.businessName}/${table.className}Service"))
            // Java module-impl Test
            //  .put(javaTemplatePath("test/serviceTest"),
            //        javaModuleImplTestFilePath("service/${table.businessName}/${table.className}ServiceImplTest"))
            // Java module-api Main
            // .put(javaTemplatePath("enums/errorcode"), javaModuleApiMainFilePath("enums/ErrorCodeConstants_手动操作"))
            // Vue
            .put(vueTemplatePath("views/index.vue"),
                    vueFilePath("views/${table.moduleName}/${classNameVar}/index.vue"))
            .put(vueTemplatePath("api/api.js"),
                    vueFilePath("api/${table.moduleName}/${classNameVar}.js"))
            // SQL
            .put("codegen/sql/sql.vm", "sql/sql.sql")
            //  .put("codegen/sql/h2.vm", "sql/h2.sql")
            .build();


    private static String javaTemplatePath(String path) {
        return FILE_PATH_PREFIX + "/java/" + path + ".vm";
    }

    private static String javaModuleImplVOFilePath(String path) {
        return javaModuleFilePath("controller/${sceneEnum.basePackage}/${table.businessName}/" +
                "vo/${sceneEnum.prefixClass}${table.className}" + path, "impl", "main");
    }

    private static String javaModuleImplControllerFilePath() {
        return javaModuleFilePath("controller/${sceneEnum.basePackage}/${table.businessName}/" +
                "${sceneEnum.prefixClass}${table.className}Controller", "impl", "main");
    }

    private static String javaModuleImplMainFilePath(String path) {
        return javaModuleFilePath(path, "impl", "main");
    }

    private static String javaModuleApiMainFilePath(String path) {
        return javaModuleFilePath(path, "api", "main");
    }

    private static String javaModuleImplTestFilePath(String path) {
        return javaModuleFilePath(path, "impl", "test");
    }

    private static String javaModuleFilePath(String path, String module, String src) {
        return "mmauto-module-${table.moduleName}/" + // 顶级模块
                "mmauto-module-${table.moduleName}-" + module + "/" + // 子模块
                "src/" + src + "/java/${basePackage}/module/${table.moduleName}/" + path + ".java";
    }

    private static String vueTemplatePath(String path) {
        return FILE_PATH_PREFIX + "/vue/" + path + ".vm";
    }

    private static String vueFilePath(String path) {
        return "src/" + path;
    }

}
