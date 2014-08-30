package net.gloombone.aeterno.utils;

/**
 * Created by lslinnet on 23/06/14.
 *
 * Creates a basic blueprint of any given structure in minecraft,
 * both for village creation and multi-block structure verification.
 *
 * Based of Schemata from the Forestry codebase
 * https://github.com/ForestryMC/ForestryMC/blob/master/forestry_common/core/forestry/core/utils/Schemata.java
 *
 * ---
 *
 * Copyright 2011-2014 by SirSengir
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivs 3.0 Unported License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/3.0/.
 */
public class Blueprint {

    public enum EnumStructureBlock {
        ANY('X'), FOREIGN('F'), AIR('O'), MASTER('M'), GLASS('G'), BLOCK_A('A'), BLOCK_B('B'), BLOCK_C('C'), BLOCK_D('D'), BLOCK_E('E');

        private char key;

        private EnumStructureBlock(char key) {
            this.key = key;
        }

        public char getKey() {
            return this.key;
        }
    }

    private final String machineName;
    private EnumStructureBlock[][][] structure;
    private int width, height, depth;
    private int xOffset, yOffset, zOffset = -1;


    public Blueprint(String machineName, int width, int height, int depth, String... patterns) {
        this(machineName, width, height, depth);
        this.setStructure(patterns);
    }

    public Blueprint(String machineName, int width, int height, int depth) {
        this.machineName = machineName;
        this.structure = new EnumStructureBlock[width][height][depth];
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    private void setStructure(String... patterns) {
        String fullpattern = "";

        for (String pattern : patterns) {
            fullpattern = (new StringBuilder()).append(fullpattern).append(pattern).toString();
        }

        if (fullpattern.length() != getWidth() * getHeight() * getDepth()) {
            throw new RuntimeException("Pattern malformed : " + fullpattern + " (" + fullpattern.length() + ") not equal to (" + getWidth() + " * " + getHeight() + " * " + getDepth() + ")");
        }

        for (int w = 0; w < getWidth(); w++) {
            for (int h = 0; h < getHeight(); h++) {
                for (int d = 0; d < getDepth(); d++) {
                    for (EnumStructureBlock type : EnumStructureBlock.values()) {
                        if (type.getKey() == fullpattern.charAt(w * getHeight() * getDepth() + h * getDepth() + d)) {
                            structure[w][h][d] = type;
                            break;
                        }
                    }
                }
            }
        }
    }

    public Blueprint setOffsets(int xOffset, int yOffset, int zOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.zOffset = zOffset;

        return this;
    }

    public EnumStructureBlock getAt(int x, int y, int z, boolean rotate) {
        if (rotate) {
            return structure[z][y][x];
        }
        return structure[x][y][z];
    }

    public Vect getDimensions(boolean rotate) {
        if (rotate) {
            return new Vect(getDepth(), getHeight(), getWidth());
        }
        else {
            return new Vect(getWidth(), getHeight(), getDepth());
        }
    }

    public boolean isEnabled() {
// @todo implement Config
//        return !Config.disabledStructures.contains(machineName);
        return true;
    }

    public int getxOffset() {
        return xOffset;
    }

    public int getyOffset() {
        return yOffset;
    }

    public int getzOffset() {
        return zOffset;
    }
}
