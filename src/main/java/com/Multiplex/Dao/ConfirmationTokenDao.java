package com.Multiplex.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Multiplex.Model.ConfirmationToken;

@Repository("confirmationTokenRepository")
public interface ConfirmationTokenDao extends CrudRepository<ConfirmationToken, String> {
    ConfirmationToken findByConfirmationToken(String confirmationToken);
}