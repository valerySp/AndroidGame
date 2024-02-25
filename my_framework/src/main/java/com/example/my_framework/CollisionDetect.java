package com.example.my_framework;

public class CollisionDetect {

    private static double object1X;
    private static double object1Y;
    private static double object2X;
    private static double object2Y;

    private static double radiusObject1;
    private static double radiusObject2;

    private static double dx;
    private static double dy;

    private static double distanceObjects;

    public static boolean collisionDetect(ObjectFW object1, ObjectFW object2) {

        object1X = object1.getHitBox().centerX();
        object1Y = object1.getHitBox().centerY();

        object2X = object2.getHitBox().centerX();
        object2Y = object2.getHitBox().centerY();

        radiusObject1 = object1.getRadius();
        radiusObject2 = object2.getRadius();

        dx = object1X - object2X;
        dy = object1Y - object2Y;

        distanceObjects = Math.sqrt(dx * dx + dy * dy);

        return distanceObjects < (radiusObject1 + radiusObject2);
    }
}
