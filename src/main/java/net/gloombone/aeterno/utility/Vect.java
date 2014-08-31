package net.gloombone.aeterno.utility;

/**
 * Generic class to represent a position or dimension.
 *
 * Work is based of Vect from the Forestry codebase
 * https://github.com/ForestryMC/ForestryMC/blob/master/forestry_common/core/forestry/core/utility/Vect.java
 * ---
 *
 * Copyright 2011-2014 by SirSengir
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivs 3.0 Unported License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/3.0/.
 */
public class Vect {
    public int x;
    public int y;
    public int z;

    public Vect(int[] dim) {
        if (dim.length != 3) {
            throw new RuntimeException("Cannot instantiate a vector with less or more than 3 points.");
        }

        this.x = dim[0];
        this.y = dim[1];
        this.z = dim[2];
    }

    public Vect(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Simply add another vector to this vector.
     *
     * @param other Vect
     * @return result Vect
     */
    public Vect add(Vect other) {
        Vect result = new Vect(x, y, z);
        result.x += other.x;
        result.y += other.y;
        result.z += other.z;
        return result;
    }

    public Vect multiply(float factor) {
        Vect result = new Vect(x, y, z);
        result.x *= factor;
        result.y *= factor;
        result.z *= factor;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%sx%sx%s;", x, y, z);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        result = prime * result + z;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Vect other = (Vect) obj;
        if (x != other.x) {
            return false;
        }
        if (y != other.y) {
            return false;
        }
        if (z != other.z) {
            return false;
        }
        return true;
    }
}
