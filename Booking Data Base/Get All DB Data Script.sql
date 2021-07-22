SELECT * FROM City JOIN
	company_plan JOIN
		Country JOIN
			Hotel JOIN
				plan JOIN
					Plane JOIN
						Reservation JOIN
							Room JOIN
								Room_Reserved JOIN
									Room_Type JOIN
										Travel_Company JOIN
											mydb.User JOIN
												User_Account;