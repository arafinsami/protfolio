package com.hcl.protfolio.controller;


import com.hcl.protfolio.dto.PortfolioDTO;
import com.hcl.protfolio.entity.Portfolio;
import com.hcl.protfolio.mapper.PortfolioMapper;
import com.hcl.protfolio.service.PortfolioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.hcl.protfolio.exception.ApiError.fieldError;
import static com.hcl.protfolio.utils.ResponseBuilder.error;
import static com.hcl.protfolio.utils.ResponseBuilder.success;
import static com.hcl.protfolio.utils.StringUtils.toJson;
import static org.springframework.http.ResponseEntity.badRequest;


@RestController
@RequiredArgsConstructor
@Tag(name = "Portfolio API")
@RequestMapping(path = "Portfolio")
public class PortfolioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PortfolioController.class);

    protected final PortfolioMapper portfolioMapper;

    private final PortfolioService portfolioService;

    @PostMapping
    @Operation(summary = "save Portfolio")
    public ResponseEntity<JSONObject> save(@Valid @RequestBody PortfolioDTO request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return badRequest().body(error(fieldError(bindingResult)).getJson());
        }
        Portfolio portfolio = portfolioService.save(request);
        LOGGER.info("account save response: {} ", toJson(portfolio));
        PortfolioDTO dto = portfolioMapper.from(portfolio);
        return new ResponseEntity<>(success(dto).getJson(), HttpStatus.CREATED);
    }
}
