package com.iconic.keygenerator.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * +-------------------+--------------+------+-----+---------+-------+ | Field |
 * Type | Null | Key | Default | Extra |
 * +-------------------+--------------+------+-----+---------+-------+ |
 * CLIENT_ID | int(11) | NO | MUL | NULL | | | CLIENT_KEY | varchar(255) | NO |
 * PRI | NULL | | | DOMAIN | varchar(255) | YES | | NULL | | | MAX_REQUEST |
 * int(11) | YES | | 3 | | | PROFILE_ID | int(11) | NO | | NULL | | |
 * RECYCLE_INSTANCES | tinyint(1) | YES | | 1 | | | MAX_INSTANCES | int(4) | YES
 * | | 1 | | | ALWAYS_MS_HUB | tinyint(1) | YES | | NULL | | | EDISCOVERY |
 * tinyint(1) | YES | | NULL | |
 * +-------------------+--------------+------+-----+---------+-------+
 *
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "CLIENT_KEY")
public class ClientKey {

	@Id
	@Column(name = "CLIENT_KEY")
	private String clientKey;
	
	@OneToOne(targetEntity = Client.class)
	@JoinColumn(name = "CLIENT_ID")
	private Client client;
	
	@Column(name = "DOMAIN")
	private String domain;
	
	@Column(name = "MAX_REQUEST")
	private Integer maxRequest;
	
	@Column(name = "PROFILE_ID")
	private Integer profileId;
	
	@Column(name = "RECYCLE_INSTANCES")
	private Boolean recycleInstances;
	
	@Column(name = "MAX_INSTANCES")
	private Integer maxInstances;
	
	@Column(name="ALWAYS_MS_HUB")
	private Boolean alwaysMsHub;
	
	@Column(name = "EDISCOVERY")
	private Boolean eDiscovery;

}
