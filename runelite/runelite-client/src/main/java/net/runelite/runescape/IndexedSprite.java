package net.runelite.runescape;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.rs.api.RSIndexedSprite;

@ObfuscatedName("li")
@Implements("IndexedSprite")
public final class IndexedSprite extends Rasterizer2D implements RSIndexedSprite {
    @ObfuscatedName("l")
    @Export("offsetY")
    public int offsetY;
    @ObfuscatedName("r")
    @Export("palette")
    public int[] palette;
    @ObfuscatedName("e")
    @Export("width")
    public int width;
    @ObfuscatedName("w")
    @Export("originalHeight")
    public int originalHeight;
    @ObfuscatedName("q")
    @Export("height")
    public int height;
    @ObfuscatedName("b")
    @Export("originalWidth")
    public int originalWidth;
    @ObfuscatedName("c")
    @Export("offsetX")
    public int offsetX;
    @ObfuscatedName("g")
    @Export("pixels")
    public byte[] pixels;

    @ObfuscatedName("r")
    public void method828(int var1, int var2, int var3) {
        for (int var4 = 0; var4 < this.palette.length; ++var4) {
            int var5 = this.palette[var4] >> 16 & 255;
            var5 += var1;
            if (var5 < 0) {
                var5 = 0;
            } else if (var5 > 255) {
                var5 = 255;
            }

            int var6 = this.palette[var4] >> 8 & 255;
            var6 += var2;
            if (var6 < 0) {
                var6 = 0;
            } else if (var6 > 255) {
                var6 = 255;
            }

            int var7 = this.palette[var4] & 255;
            var7 += var3;
            if (var7 < 0) {
                var7 = 0;
            } else if (var7 > 255) {
                var7 = 255;
            }

            this.palette[var4] = var7 + (var6 << 8) + (var5 << 16);
        }

    }

    @ObfuscatedName("e")
    public void method824(int var1, int var2) {
        var1 += this.offsetX;
        var2 += this.offsetY;
        int var3 = var1 + var2 * Rasterizer2D.graphicsPixelsWidth;
        int var4 = 0;
        int var5 = this.height;
        int var6 = this.width;
        int var7 = Rasterizer2D.graphicsPixelsWidth - var6;
        int var8 = 0;
        int var9;
        if (var2 < Rasterizer2D.drawingAreaTop) {
            var9 = Rasterizer2D.drawingAreaTop - var2;
            var5 -= var9;
            var2 = Rasterizer2D.drawingAreaTop;
            var4 += var9 * var6;
            var3 += var9 * Rasterizer2D.graphicsPixelsWidth;
        }

        if (var5 + var2 > Rasterizer2D.drawingAreaRight) {
            var5 -= var5 + var2 - Rasterizer2D.drawingAreaRight;
        }

        if (var1 < Rasterizer2D.draw_region_x) {
            var9 = Rasterizer2D.draw_region_x - var1;
            var6 -= var9;
            var1 = Rasterizer2D.draw_region_x;
            var4 += var9;
            var3 += var9;
            var8 += var9;
            var7 += var9;
        }

        if (var6 + var1 > Rasterizer2D.drawingAreaBottom) {
            var9 = var6 + var1 - Rasterizer2D.drawingAreaBottom;
            var6 -= var9;
            var8 += var9;
            var7 += var9;
        }

        if (var6 > 0 && var5 > 0) {
            method818(Rasterizer2D.graphicsPixels, this.pixels, this.palette, var4, var3, var6, var5, var7, var8);
        }
    }

    @ObfuscatedName("c")
    public void method819(int var1, int var2, int var3, int var4) {
        int var5 = this.width;
        int var6 = this.height;
        int var7 = 0;
        int var8 = 0;
        int var9 = this.originalWidth;
        int var10 = this.originalHeight;
        int var11 = (var9 << 16) / var3;
        int var12 = (var10 << 16) / var4;
        int var13;
        if (this.offsetX > 0) {
            var13 = (var11 + (this.offsetX << 16) - 1) / var11;
            var1 += var13;
            var7 += var13 * var11 - (this.offsetX << 16);
        }

        if (this.offsetY > 0) {
            var13 = (var12 + (this.offsetY << 16) - 1) / var12;
            var2 += var13;
            var8 += var13 * var12 - (this.offsetY << 16);
        }

        if (var5 < var9) {
            var3 = (var11 + ((var5 << 16) - var7) - 1) / var11;
        }

        if (var6 < var10) {
            var4 = (var12 + ((var6 << 16) - var8) - 1) / var12;
        }

        var13 = var1 + var2 * Rasterizer2D.graphicsPixelsWidth;
        int var14 = Rasterizer2D.graphicsPixelsWidth - var3;
        if (var2 + var4 > Rasterizer2D.drawingAreaRight) {
            var4 -= var2 + var4 - Rasterizer2D.drawingAreaRight;
        }

        int var15;
        if (var2 < Rasterizer2D.drawingAreaTop) {
            var15 = Rasterizer2D.drawingAreaTop - var2;
            var4 -= var15;
            var13 += var15 * Rasterizer2D.graphicsPixelsWidth;
            var8 += var12 * var15;
        }

        if (var3 + var1 > Rasterizer2D.drawingAreaBottom) {
            var15 = var3 + var1 - Rasterizer2D.drawingAreaBottom;
            var3 -= var15;
            var14 += var15;
        }

        if (var1 < Rasterizer2D.draw_region_x) {
            var15 = Rasterizer2D.draw_region_x - var1;
            var3 -= var15;
            var13 += var15;
            var7 += var11 * var15;
            var14 += var15;
        }

        method814(Rasterizer2D.graphicsPixels, this.pixels, this.palette, var7, var8, var13, var14, var3, var4, var11, var12, var5);
    }

    @Export("setPixels")
    public void setPixels(byte[] var1) {
        this.pixels = var1;
    }

    @Export("getPixels")
    public byte[] getPixels() {
        return this.pixels;
    }

    @Export("setPalette")
    public void setPalette(int[] var1) {
        this.palette = var1;
    }

    @Export("getPalette")
    public int[] getPalette() {
        return this.palette;
    }

    @Export("setWidth")
    public void setWidth(int var1) {
        this.width = var1;
    }

    @Export("getWidth")
    public int getWidth() {
        return this.width;
    }

    @Export("setHeight")
    public void setHeight(int var1) {
        this.height = var1;
    }

    @Export("getHeight")
    public int getHeight() {
        return this.height;
    }

    @Export("setOffsetX")
    public void setOffsetX(int var1) {
        this.offsetX = var1;
    }

    @Export("getOffsetX")
    public int getOffsetX() {
        return this.offsetX;
    }

    @Export("setOffsetY")
    public void setOffsetY(int var1) {
        this.offsetY = var1;
    }

    @Export("getOffsetY")
    public int getOffsetY() {
        return this.offsetY;
    }

    @Export("setOriginalWidth")
    public void setOriginalWidth(int var1) {
        this.originalWidth = var1;
    }

    @Export("getOriginalWidth")
    public int getOriginalWidth() {
        return this.originalWidth;
    }

    @Export("setOriginalHeight")
    public void setOriginalHeight(int var1) {
        this.originalHeight = var1;
    }

    @Export("getOriginalHeight")
    public int getOriginalHeight() {
        return this.originalHeight;
    }

    @ObfuscatedName("g")
    public void method815() {
        if (this.width != this.originalWidth || this.height != this.originalHeight) {
            byte[] var1 = new byte[this.originalWidth * this.originalHeight];
            int var2 = 0;

            for (int var3 = 0; var3 < this.height; ++var3) {
                for (int var4 = 0; var4 < this.width; ++var4) {
                    var1[var4 + (var3 + this.offsetY) * this.originalWidth + this.offsetX] = this.pixels[var2++];
                }
            }

            this.pixels = var1;
            this.width = this.originalWidth;
            this.height = this.originalHeight;
            this.offsetX = 0;
            this.offsetY = 0;
        }
    }

    @ObfuscatedName("q")
    static void method818(int[] var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        int var9 = -(var5 >> 2);
        var5 = -(var5 & 3);

        for (int var10 = -var6; var10 < 0; ++var10) {
            int var11;
            byte var12;
            for (var11 = var9; var11 < 0; ++var11) {
                var12 = var1[var3++];
                if (var12 != 0) {
                    var0[var4++] = var2[var12 & 255] | -16777216;
                } else {
                    ++var4;
                }

                var12 = var1[var3++];
                if (var12 != 0) {
                    var0[var4++] = var2[var12 & 255] | -16777216;
                } else {
                    ++var4;
                }

                var12 = var1[var3++];
                if (var12 != 0) {
                    var0[var4++] = var2[var12 & 255] | -16777216;
                } else {
                    ++var4;
                }

                var12 = var1[var3++];
                if (var12 != 0) {
                    var0[var4++] = var2[var12 & 255] | -16777216;
                } else {
                    ++var4;
                }
            }

            for (var11 = var5; var11 < 0; ++var11) {
                var12 = var1[var3++];
                if (var12 != 0) {
                    var0[var4++] = var2[var12 & 255] | -16777216;
                } else {
                    ++var4;
                }
            }

            var4 += var7;
            var3 += var8;
        }

    }

    @ObfuscatedName("i")
    static void method814(int[] var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
        int var12 = var3;

        for (int var13 = -var8; var13 < 0; ++var13) {
            int var14 = var11 * (var4 >> 16);

            for (int var15 = -var7; var15 < 0; ++var15) {
                byte var16 = var1[(var3 >> 16) + var14];
                if (var16 != 0) {
                    var0[var5++] = var2[var16 & 255] | -16777216;
                } else {
                    ++var5;
                }

                var3 += var9;
            }

            var4 += var10;
            var3 = var12;
            var5 += var6;
        }

    }
}
