<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:a="http://article.nure.ua/entity/article/">
    <xsl:template match="/">
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
                <title>Album Details</title>
            </head>
            <body>
                <h1>Album Details</h1>
                <xsl:apply-templates select="a:albums/a:album"/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="album">
        <div>
            <h2><xsl:value-of select="header"/></h2>
            <p><strong>Text:</strong> <xsl:value-of select="text"/></p>
            <p><strong>Date:</strong> <xsl:value-of select="date"/></p>
            <h3>Image</h3>
            <p><strong>image_url:</strong> <xsl:value-of select="image/image_url"/></p>
            <p><strong>Created By:</strong> <xsl:value-of select="created_by/username"/></p>
            <p><strong>Access Level:</strong> <xsl:value-of select="access_level"/></p>
        </div>
    </xsl:template>
</xsl:stylesheet>
