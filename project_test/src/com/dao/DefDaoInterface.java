package com.dao;

import java.util.Optional;

public interface DefDaoInterface
{
	public Optional<String> getLastKeyId(String keyName);
}
