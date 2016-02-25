<#import "/layout/layout.ftl" as layout>
<@layout.myLayout "Home page">

<h1>Spring Super Blog</h1>

<#if articles??>

    <#list articles as article>
        <h3>
            <a href="/article/${article.id}">${article.title}</a>
        </h3>
        <p>${article.date?date}</p>
    </#list>

<#else>
  <div class="alert alert-warning">Al momento non sono presenti Articoli in questo blog</div>
</#if>

</@layout.myLayout>