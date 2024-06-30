package projekuas;

import java.util.Scanner;

public class ConsoleBookstoreApp {
    private static BookStorage bookStorage = new BookStorage(3);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambahkan Buku");
            System.out.println("2. Cari Buku");
            System.out.println("3. Lihat Semua Buku");
            System.out.println("4. Keluar");
            System.out.print("Pilih: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    searchBook();
                    break;
                case 3:
                    displayBooks();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void addBook() {
        if (bookStorage.getCount() < 3) {
            System.out.print("Judul: ");
            String judul = scanner.nextLine();
            System.out.print("Nama Pengarang: ");
            String namaPengarang = scanner.nextLine();
            System.out.print("Penerbit: ");
            String penerbit = scanner.nextLine();
            System.out.print("Tahun Cetak: ");
            int tahunCetak = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            System.out.print("Kategori (su/r/d/a): ");
            String kategori = scanner.nextLine();

            Book book = new Book(judul, namaPengarang, penerbit, tahunCetak, kategori);
            bookStorage.addBook(book);
        } else {
            System.out.println("Anda hanya bisa menambahkan 3 buku.");
        }
    }

    private static void searchBook() {
        System.out.print("Masukkan judul buku yang dicari: ");
        String title = scanner.nextLine();
        Book book = bookStorage.searchBook(title);
        if (book != null) {
            System.out.println("Buku ditemukan:\n" + book.toString());
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    private static void displayBooks() {
        Book[] books = bookStorage.getAllBooks();
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println("Buku " + (i + 1) + ":\n" + book.toString() + "\n");
        }
    }
}
