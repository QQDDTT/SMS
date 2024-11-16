package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.model.Authority;

/**
 * Authority mapper.
 *
 * @author QQDDTT
 * @since 0.2
 */
@Mapper
public interface AuthorityMapper {

    List<Authority> selectAllAuthorities();

    Authority selectAuthorityById(String authorityId);

    boolean insertAuthority(Authority authority);

    boolean updateAuthority(Authority authority);

    boolean deleteAuthorityById(String authorityId);
}