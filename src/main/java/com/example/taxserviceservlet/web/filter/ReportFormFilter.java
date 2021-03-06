package com.example.taxserviceservlet.web.filter;

import com.example.taxserviceservlet.entity.TaxPeriod;
import com.example.taxserviceservlet.web.dto.ReportDTO;
import com.example.taxserviceservlet.web.dto.ReportFormError;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Pattern;

@WebFilter(value = {"/user/report-form", "/user/report-edit"})
public class ReportFormFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if (request.getMethod().equalsIgnoreCase("POST")) {

            String income = request.getParameter("income");
            String taxRate = request.getParameter("taxRate");
            String period = request.getParameter("period");
            String year = request.getParameter("year");

            ReportFormError reportFormError = new ReportFormError();

            if (income.isEmpty() || !Pattern.matches("^[1-9][0-9]+$", income))
                reportFormError.setIncomeInvalid(true);

            if (taxRate.isEmpty() || !Pattern.matches("^[1-9][0-9]?$", taxRate))
                reportFormError.setTaxRateInvalid(true);

            if (period.isEmpty())
                reportFormError.setPeriodInvalid(true);

            if (year.isEmpty() || !Pattern.matches("^[2][0][0-9]{2}$", year))
                reportFormError.setYearInvalid(true);

            if (!reportFormError.hasErrors()) {

                ReportDTO reportDTO = ReportDTO.builder()
                        .income(Integer.valueOf(income))
                        .taxRate(Integer.valueOf(taxRate))
                        .taxPeriod(TaxPeriod.valueOf(period))
                        .year(Integer.valueOf(year))
                        .build();

                request.setAttribute("reportDTO", reportDTO);
            }

            request.setAttribute("errorReportFormDTO", reportFormError);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
