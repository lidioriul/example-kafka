## Para utilizar valores variaveis dentro do application.properties usando Spring Boot

### Passo 1: Incluir propriedades, profiles e plugins no arquivo pom.xml

```
<properties>
  <db.username></db.username>
  <db.password></db.password>
</properties>

<profiles>
  <profile>
    <id>teste</id>
    <properties>
      <exampleProfile>profile-teste</exampleProfile>
      <db.username>root</db.username>
      <db.password>root</db.password>
    </properties>
    <activation>
      <!-- caso queira deixar um profile já setado por padrão -->
      <activeByDefault>true</activeByDefault>
    </activation>
  </profile>
  <profile>
    <id>dev</id>
    <properties>
      <exampleProfile>profile-dev</exampleProfile>
      <db.username>dev</db.username>
      <db.password>dev</db.password>
    </properties>
  </profile>
</profiles>

<build>
  <resources>
    <resource>
      <directory>src/main/resources</directory>
      <filtering>true</filtering>
    </resource>
  </resources>
  <pluginManagement>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
    </plugins>
  </pluginManagement>
</build>
```

### Passo 2. Incluir no arquivo application.properties. O spring vai pegar e substituir o que estiver dentro do @
```
example.profile=@exampleProfile@
exemplo.spring.datasource.username=@db.username@
exemplo.spring.datasource.password=@db.password@
```

### Passo 3. Para visualizar é só chamar no código utilizando o @Value

```
@Value("${examplo.spring.datasource.username}")
private String dbUsername;
@Value("${examplo.spring.datasource.password}")
private String dbPassword;
```

### Passo 4. Para executar rodar o sistema vc deve incluir -P *<id_profile>*

> **Por exemplo:** mvn spring-boot: run -P *<id_profile>*
