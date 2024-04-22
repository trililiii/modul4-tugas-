package books;

// Interface
interface iMenu {
    void menu();
}

// Student "implement" the menu interface
class Student implements iMenu {
    @Override
    public void menu() {
        System.out.println("Student Menu:");
        System.out.println("1. Buku terpinjam");
        System.out.println("2. Pinjam buku");
        System.out.println("3. Display book");
        System.out.println("4. Logout");
    }
}

// Class Admin implementing iMenu
class Admin implements iMenu {
    @Override
    public void menu() {
        System.out.println("Admin Menu:");
        System.out.println("1. Add Student");
        System.out.println("2. Display registered student");
        System.out.println("3. Logout");
    }
}