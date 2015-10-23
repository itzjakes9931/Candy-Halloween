/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fisica;

/**
 *
 * @author Eduardo
 */
public class AABB {
    Vec2 min;
    Vec2 max;
    
   public boolean AABBvsAABB( AABB a, AABB b ){
    // Exit with no intersection if found separated along an axis
    if(a.max.getX() < b.min.getX() || a.min.getX() > b.max.getX()) return false;
    if(a.max.getY() < b.min.getY() || a.min.getY() > b.max.getY()) return false;
    // No separating axis found, therefor there is at least one overlapping axis
    return true;
  }
    
}
