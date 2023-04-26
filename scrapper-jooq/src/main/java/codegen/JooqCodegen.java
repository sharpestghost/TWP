package codegen;

import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.*;
//Exception in thread "main" java.lang.NoSuchMethodError: 'java.lang.Boolean org.jooq.meta.jaxb.Generate.isGeneratedAnnotationJooqVersion()'
public class JooqCodegen {
    public static void main(String[] args) throws Exception {
        Database database = new Database()
                .withName("org.jooq.meta.postgres.PostgresDatabase")
                .withIncludes(".*")
                .withExcludes("")
                .withInputSchema("public");

        Jdbc jdbc = new Jdbc()
                .withDriver("org.postgresql.Driver")
                .withUrl("jdbc:postgresql://localhost:5432/scrapper")
                .withUser("admin")
                .withPassword("secretpword");

        Target target = new Target()
                .withPackageName("ru.tinkoff.edu.domain.jooq")
                .withDirectory("scrapper/src/main/java");

        Configuration configuration = new Configuration()
                .withJdbc(jdbc)
                .withGenerator(
                        new Generator()
                                .withDatabase(database)
                                .withTarget(target)
                );

        GenerationTool.generate(configuration);
    }
}