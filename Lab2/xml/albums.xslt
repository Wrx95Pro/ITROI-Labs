<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:sn="http://album.nure.ua/entity">
    <xsl:output method="html" encoding="UTF-8"/>

    <xsl:template match="/sn:albums">
        <html>
            <head>
                <title>Albums</title>
                <link rel="stylesheet" type="text/css" href="style.css"/>
            </head>
            <body>
                <div class="albums">
                    <div>
                        <xsl:apply-templates select="sn:album[sn:access_level='PUBLIC']"/>
                    </div>
                    <div>
                        <xsl:apply-templates select="sn:album[sn:access_level='LINK_ONLY']"/>
                    </div>
                    <div>
                        <xsl:apply-templates select="sn:album[sn:access_level='PRIVATE']"/>
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>

    <!-- Match 'sn:album' elements -->
    <xsl:template match="sn:album">
        <div class="album">
            <h1>
                <xsl:value-of select="sn:header"/>
            </h1>
            <p>
                <xsl:value-of select="sn:text"/>
            </p>
            <div class="images">
                <xsl:apply-templates select="sn:image"/>
            </div>
            <xsl:call-template name="created-by"/>
            <p>Date:
                <xsl:value-of select="sn:date"/>
            </p>
            <i>
                <xsl:apply-templates select="sn:access_level"/>
            </i>
        </div>
    </xsl:template>

    <xsl:template match="sn:image">
        <xsl:choose>
            <xsl:when test="sn:image_url">
                <img src="{sn:image_url}"/>
            </xsl:when>
            <xsl:otherwise>
                <p>Failed to load image.</p>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

    <xsl:template name="created-by">
        <div class="created-by">
            <span class="user-info created-by-item">
                <i>Created by:
                    <a href="/{sn:created_by/sn:username}">
                        <xsl:value-of select="sn:created_by/sn:username"/>
                    </a>
                </i>
            </span>
        </div>
    </xsl:template>

    <xsl:template match="sn:access_level">
        <xsl:choose>
            <xsl:when test=".='PRIVATE'">Album is private</xsl:when>
            <xsl:when test=".='LINK_ONLY'">Album is accessible via link</xsl:when>
            <xsl:when test=".='PUBLIC'">Album is publicly visible</xsl:when>
            <xsl:otherwise>Unknown access level</xsl:otherwise> <!-- Handle other cases if needed -->
        </xsl:choose>
    </xsl:template>
</xsl:stylesheet>




