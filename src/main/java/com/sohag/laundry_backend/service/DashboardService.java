package com.sohag.laundry_backend.service;

import com.sohag.laundry_backend.util.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.Date;

@Service
public class DashboardService {

    private final CustomerService customerService;
    private final EmployeeService employeeService;
    private final TransactionService transactionService;
    private final ProductionService productionService;

    public DashboardService(CustomerService customerService, EmployeeService employeeService, TransactionService transactionService, ProductionService productionService) {
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.transactionService = transactionService;
        this.productionService = productionService;
    }

    @Transactional
    public void setDashboardInfo(Model model) {
        Date from = DateUtil.getStartOfYear(new Date());
        Date to = DateUtil.getEndOfYear(new Date());
        model.addAttribute("totalCustomer", customerService.countAll());
        model.addAttribute("totalEmployee", employeeService.countAllActive());
        model.addAttribute("totalIncomeCount", transactionService.countAllActiveIncome());
        model.addAttribute("totalPendingIncomeCount", transactionService.countAllInactiveIncome());
        Double income = transactionService.totalIncome(from, to);
        Double expense = productionService.totalExpense(from, to);
        model.addAttribute("totalIncomeThisYear", income);
        model.addAttribute("totalExpenseThisYear", expense);
        model.addAttribute("totalProfit", (income - expense));
    }
}
