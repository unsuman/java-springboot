package com.assignment.college;

/**
 * This is a special utility class that enforces the correct
 * package structure for this application by linking together
 * key domain objects.
 */
public final class PackageEnforcer {
    private PackageEnforcer() {
        // Private constructor to prevent instantiation
    }
    
    /**
     * This method creates instances of all key domain classes
     * to force the compiler to recognize them in the correct package.
     */
    public static void validatePackageStructure() {
        // Create instances of key classes in the correct package
        com.assignment.college.entity.Author author = new com.assignment.college.entity.Author();
        com.assignment.college.entity.Book book = new com.assignment.college.entity.Book();
        
        // Explicitly set up the relationship between them
        book.setAuthor(author);
    }
}