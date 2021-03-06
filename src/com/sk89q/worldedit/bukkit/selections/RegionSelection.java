// $Id$
/*
 * WorldEdit
 * Copyright (C) 2010, 2011 sk89q <http://www.sk89q.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package com.sk89q.worldedit.bukkit.selections;

import static com.sk89q.worldedit.bukkit.BukkitUtil.toLocation;
import static com.sk89q.worldedit.bukkit.BukkitUtil.toVector;
import org.bukkit.Location;
import org.bukkit.World;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.regions.Region;

public abstract class RegionSelection implements Selection {

    protected World world;
    protected Region region;
    
    public RegionSelection(World world, Region region) {
        this.world = world;
        this.region = region;
    }

    @Override
    public Location getMinimumPoint() {
        return toLocation(world, region.getMinimumPoint());
    }

    @Override
    public Vector getNativeMinimumPoint() {
        return region.getMinimumPoint();
    }

    @Override
    public Location getMaximumPoint() {
        return toLocation(world, region.getMaximumPoint());
    }

    @Override
    public Vector getNativeMaximumPoint() {
        return region.getMaximumPoint();
    }

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public int getArea() {
        return region.getArea();
    }

    @Override
    public int getWidth() {
        return region.getWidth();
    }

    @Override
    public int getHeight() {
        return region.getHeight();
    }

    @Override
    public int getLength() {
        return region.getLength();
    }

    @Override
    public boolean contains(Location pt) {
        if (!pt.getWorld().equals(world)) {
            return false;
        }
        
        return region.contains(toVector(pt));
    }

}
