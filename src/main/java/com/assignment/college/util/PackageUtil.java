package com.assignment.college.util;

/**
 * This utility class helps ensure that the compiler recognizes
 * the correct package structure for our project.
 */
public class PackageUtil {
    private PackageUtil() {
        // Private constructor to prevent instantiation
    }
    
    /**
     * Utility method to verify package structure is correct
     * 
     * @return The base package name for this project
     */
    public static String getBasePackageName() {
        return "com.assignment.college";
    }
}