package com.bookstore.framework.pages.confirmations;

import com.bookstore.framework.base.BasePage;
import org.openqa.selenium.By;

public class Modals extends BasePage {

    DeleteModal deleteModal;

    public class DeleteModal {
        By confirmAllBooksDeletionBTN = By.id("closeSmallModal-ok");
        By cancelAllBooksDeletionBTN = By.id("closeSmallModal-cancel");

        public void confirmAllBookDeleting() {
            click(confirmAllBooksDeletionBTN);
        }

        public void cancelAllBooksDeletion() {
            click(cancelAllBooksDeletionBTN);
        }
    }

    public DeleteModal getDeleteModal() {
        if (deleteModal == null) {
            deleteModal = new DeleteModal();
        }
        return deleteModal;
    }
}
