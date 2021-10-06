package tests;


import org.testng.annotations.Test;

public class FindBookTests extends BaseTests {
    private String bookName = "Колобок";
    @Test
    public void testCorrectFindBook() throws InterruptedException {
        homePage.findBook(bookName);

    }

}
