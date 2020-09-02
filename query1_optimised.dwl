write(
	project(
		join(
			union(
				select(
					enrich_timestamp(
						select(
							read(f1),
							<f1.Direction_Name = 'North'>
						),
						f1.Date,
						'%d/%c/%Y %H:%i:%s',
						"01/02/2018"
					),
					<DAYOFWEEK(DATE(f1.Date)) = '4' AND
					TIME(f1.Date) >= '17:00:00' AND
					TIME(f1.Date) < '18:00:00'>
				),
				select(
					enrich_timestamp(
						select(
							read(f2),
							<f2.Direction_Name = 'NorthEast'>
						),
						f2.Date,
						'%d/%c/%Y %H:%i:%s',
						"01/02/2018"
					),
					<DAYOFWEEK(DATE(f2.Date)) = '4' AND
					TIME(f2.Date) >= '17:00:00' AND
					TIME(f2.Date) < '18:00:00'>
				)
			),
			select(
				read(f3),
				<f3.StartSite = '1083' AND
				f3.EndSite = '1415'>
			),
			f1.Site_ID = f3.StartSite OR f2.Site_ID = f3.EndSite
		),
		<LinkLength, Speed_mph>
	),
	JT(LinkLength,AVG(Speed_mph)),
	example_1_results.csv
)
