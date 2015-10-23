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
public class Circle {
    float radius;
    Vec2 position;
    
    public boolean CirclevsCircle( Circle a, Circle b ){
      float r = a.radius + b.radius;
      r *= r;
      return (r < (a.position.getX() + b.position.getX())*(a.position.getX() + b.position.getX())
              + (a.position.getY() + b.position.getY())*(a.position.getY() + b.position.getY()));
    }
}
