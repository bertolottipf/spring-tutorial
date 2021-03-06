<#macro myLayout title="Layout example">
<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="/webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <!-- Optional theme -->
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.5/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->

    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .error-template {padding: 40px 15px;text-align: center;}
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="https://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
  </head>
<body>

    <div class="container">

        <#include "./header.ftl"/>

        <#if (flash_error)??>
            <div class="alert alert-danger">
                ${flash_error}
            </div>
        </#if>

        <#if (flash_success)??>
            <div class="alert alert-success">
                ${flash_success}
            </div>
        </#if>

        <#nested/>

        <#include "./footer.ftl"/>

    </div> <!-- /container -->
    <script type="text/javascript" src="/webjars/jquery/2.2.0/jquery.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
</#macro>