<#import "/layout/layout.ftl" as layout>
<@layout.myLayout "Article">

<h1>${article.title}</h1>
<h3>${article.date?date}</h3>
<p>
    ${article.summary}
</p>

</@layout.myLayout>