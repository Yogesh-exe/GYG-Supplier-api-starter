package com.getyourguide.supplier.exception;

import com.getyourguide.connectivity.supplierapi.openapi.model.CategoryDTO;

public class InvalidTicketCategoryException extends ServiceException {
    private static final long serialVersionUID = 1L;

    private final CategoryDTO ticketCategory;

    public InvalidTicketCategoryException(OperationId operationId, String message, CategoryDTO category) {
        super(operationId, ErrorCode.INVALID_TICKET_CATEGORY, message);
        this.ticketCategory = category;
    }

    public CategoryDTO getTicketCategory() {
        return this.ticketCategory;
    }
}
