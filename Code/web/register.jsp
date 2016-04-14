<%-- 
    Document   : register
    Created on : 25-Dec-2014, 22:20:48
    Author     : Jasim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header/headData.jsp" flush="true" ></jsp:include>
            <script>

            </script>
        </head>
        <body>
        <jsp:include page="header/header.jsp" flush="true" ></jsp:include>
            <div class="container">
                <div class="text-center">
                    <h1>Register</h1>
                </div>
                <div class="row" style="width: 100%">
                    <div class="col-md-4" style="width: 100%">
                    </div>
                    <div class="col-md-4" style="width: 100%">
                        <span>
                            <br>
                            <br>
                            <br>
                        </span>
                        <form action="submit_register" name="registrationform" id="registrationform"  enctype="multipart/form-data" method="POST" >
                            <div class="form-group">
                                <p>First Name: </p>
                                <input class="form-control" id="fname" name="fname" required >
                                <span></span>
                            </div>

                            <div class="form-group">
                                <p>Last Name: </p>
                                <input class="form-control" id="lname" name="lname" required >
                                <span></span>
                            </div>


                            <div class="form-group">
                                <p>Screen Name: </p>
                                <input class="form-control" id="screenname" name="uname" required >
                                <span></span>
                            </div>


                            <div class="form-group">
                                <p>Email: </p>
                                <input type="email" class="form-control" id="email" name="email" ng-model="user.email" required />
                                <span></span>
                            </div>

                            <div class="form-group">
                                <p>Gender: </p>
                                <input type="radio"  id="gender" name="gender" value="Male" ><p>Male &nbsp &nbsp</p>
                                <input type="radio"  id="gender" name="gender" value="Female" ><p>Female &nbsp &nbsp</p>
                            </div>

                            <div class="form-group">
                                <p>Country: </p>
                                <select name="country">
                                    <option value="">Country...</option>
                                    <option value="Afganistan">Afghanistan</option>
                                    <option value="Albania">Albania</option>
                                    <option value="Algeria">Algeria</option>
                                    <option value="American Samoa">American Samoa</option>
                                    <option value="Andorra">Andorra</option>
                                    <option value="Angola">Angola</option>
                                    <option value="Anguilla">Anguilla</option>
                                    <option value="Antigua &amp; Barbuda">Antigua &amp; Barbuda</option>
                                    <option value="Argentina">Argentina</option>
                                    <option value="Armenia">Armenia</option>
                                    <option value="Aruba">Aruba</option>
                                    <option value="Australia">Australia</option>
                                    <option value="Austria">Austria</option>
                                    <option value="Azerbaijan">Azerbaijan</option>
                                    <option value="Bahamas">Bahamas</option>
                                    <option value="Bahrain">Bahrain</option>
                                    <option value="Bangladesh">Bangladesh</option>
                                    <option value="Barbados">Barbados</option>
                                    <option value="Belarus">Belarus</option>
                                    <option value="Belgium">Belgium</option>
                                    <option value="Belize">Belize</option>
                                    <option value="Benin">Benin</option>
                                    <option value="Bermuda">Bermuda</option>
                                    <option value="Bhutan">Bhutan</option>
                                    <option value="Bolivia">Bolivia</option>
                                    <option value="Bonaire">Bonaire</option>
                                    <option value="Bosnia &amp; Herzegovina">Bosnia &amp; Herzegovina</option>
                                    <option value="Botswana">Botswana</option>
                                    <option value="Brazil">Brazil</option>
                                    <option value="British Indian Ocean Ter">British Indian Ocean Ter</option>
                                    <option value="Brunei">Brunei</option>
                                    <option value="Bulgaria">Bulgaria</option>
                                    <option value="Burkina Faso">Burkina Faso</option>
                                    <option value="Burundi">Burundi</option>
                                    <option value="Cambodia">Cambodia</option>
                                    <option value="Cameroon">Cameroon</option>
                                    <option value="Canada">Canada</option>
                                    <option value="Canary Islands">Canary Islands</option>
                                    <option value="Cape Verde">Cape Verde</option>
                                    <option value="Cayman Islands">Cayman Islands</option>
                                    <option value="Central African Republic">Central African Republic</option>
                                    <option value="Chad">Chad</option>
                                    <option value="Channel Islands">Channel Islands</option>
                                    <option value="Chile">Chile</option>
                                    <option value="China">China</option>
                                    <option value="Christmas Island">Christmas Island</option>
                                    <option value="Cocos Island">Cocos Island</option>
                                    <option value="Colombia">Colombia</option>
                                    <option value="Comoros">Comoros</option>
                                    <option value="Congo">Congo</option>
                                    <option value="Cook Islands">Cook Islands</option>
                                    <option value="Costa Rica">Costa Rica</option>
                                    <option value="Cote DIvoire">Cote D'Ivoire</option>
                                    <option value="Croatia">Croatia</option>
                                    <option value="Cuba">Cuba</option>
                                    <option value="Curaco">Curacao</option>
                                    <option value="Cyprus">Cyprus</option>
                                    <option value="Czech Republic">Czech Republic</option>
                                    <option value="Denmark">Denmark</option>
                                    <option value="Djibouti">Djibouti</option>
                                    <option value="Dominica">Dominica</option>
                                    <option value="Dominican Republic">Dominican Republic</option>
                                    <option value="East Timor">East Timor</option>
                                    <option value="Ecuador">Ecuador</option>
                                    <option value="Egypt">Egypt</option>
                                    <option value="El Salvador">El Salvador</option>
                                    <option value="Equatorial Guinea">Equatorial Guinea</option>
                                    <option value="Eritrea">Eritrea</option>
                                    <option value="Estonia">Estonia</option>
                                    <option value="Ethiopia">Ethiopia</option>
                                    <option value="Falkland Islands">Falkland Islands</option>
                                    <option value="Faroe Islands">Faroe Islands</option>
                                    <option value="Fiji">Fiji</option>
                                    <option value="Finland">Finland</option>
                                    <option value="France">France</option>
                                    <option value="French Guiana">French Guiana</option>
                                    <option value="French Polynesia">French Polynesia</option>
                                    <option value="French Southern Ter">French Southern Ter</option>
                                    <option value="Gabon">Gabon</option>
                                    <option value="Gambia">Gambia</option>
                                    <option value="Georgia">Georgia</option>
                                    <option value="Germany">Germany</option>
                                    <option value="Ghana">Ghana</option>
                                    <option value="Gibraltar">Gibraltar</option>
                                    <option value="Great Britain">Great Britain</option>
                                    <option value="Greece">Greece</option>
                                    <option value="Greenland">Greenland</option>
                                    <option value="Grenada">Grenada</option>
                                    <option value="Guadeloupe">Guadeloupe</option>
                                    <option value="Guam">Guam</option>
                                    <option value="Guatemala">Guatemala</option>
                                    <option value="Guinea">Guinea</option>
                                    <option value="Guyana">Guyana</option>
                                    <option value="Haiti">Haiti</option>
                                    <option value="Hawaii">Hawaii</option>
                                    <option value="Honduras">Honduras</option>
                                    <option value="Hong Kong">Hong Kong</option>
                                    <option value="Hungary">Hungary</option>
                                    <option value="Iceland">Iceland</option>
                                    <option value="India">India</option>
                                    <option value="Indonesia">Indonesia</option>
                                    <option value="Iran">Iran</option>
                                    <option value="Iraq">Iraq</option>
                                    <option value="Ireland">Ireland</option>
                                    <option value="Isle of Man">Isle of Man</option>
                                    <option value="Israel">Israel</option>
                                    <option value="Italy">Italy</option>
                                    <option value="Jamaica">Jamaica</option>
                                    <option value="Japan">Japan</option>
                                    <option value="Jordan">Jordan</option>
                                    <option value="Kazakhstan">Kazakhstan</option>
                                    <option value="Kenya">Kenya</option>
                                    <option value="Kiribati">Kiribati</option>
                                    <option value="Korea North">Korea North</option>
                                    <option value="Korea Sout">Korea South</option>
                                    <option value="Kuwait">Kuwait</option>
                                    <option value="Kyrgyzstan">Kyrgyzstan</option>
                                    <option value="Laos">Laos</option>
                                    <option value="Latvia">Latvia</option>
                                    <option value="Lebanon">Lebanon</option>
                                    <option value="Lesotho">Lesotho</option>
                                    <option value="Liberia">Liberia</option>
                                    <option value="Libya">Libya</option>
                                    <option value="Liechtenstein">Liechtenstein</option>
                                    <option value="Lithuania">Lithuania</option>
                                    <option value="Luxembourg">Luxembourg</option>
                                    <option value="Macau">Macau</option>
                                    <option value="Macedonia">Macedonia</option>
                                    <option value="Madagascar">Madagascar</option>
                                    <option value="Malaysia">Malaysia</option>
                                    <option value="Malawi">Malawi</option>
                                    <option value="Maldives">Maldives</option>
                                    <option value="Mali">Mali</option>
                                    <option value="Malta">Malta</option>
                                    <option value="Marshall Islands">Marshall Islands</option>
                                    <option value="Martinique">Martinique</option>
                                    <option value="Mauritania">Mauritania</option>
                                    <option value="Mauritius">Mauritius</option>
                                    <option value="Mayotte">Mayotte</option>
                                    <option value="Mexico">Mexico</option>
                                    <option value="Midway Islands">Midway Islands</option>
                                    <option value="Moldova">Moldova</option>
                                    <option value="Monaco">Monaco</option>
                                    <option value="Mongolia">Mongolia</option>
                                    <option value="Montserrat">Montserrat</option>
                                    <option value="Morocco">Morocco</option>
                                    <option value="Mozambique">Mozambique</option>
                                    <option value="Myanmar">Myanmar</option>
                                    <option value="Nambia">Nambia</option>
                                    <option value="Nauru">Nauru</option>
                                    <option value="Nepal">Nepal</option>
                                    <option value="Netherland Antilles">Netherland Antilles</option>
                                    <option value="Netherlands">Netherlands (Holland, Europe)</option>
                                    <option value="Nevis">Nevis</option>
                                    <option value="New Caledonia">New Caledonia</option>
                                    <option value="New Zealand">New Zealand</option>
                                    <option value="Nicaragua">Nicaragua</option>
                                    <option value="Niger">Niger</option>
                                    <option value="Nigeria">Nigeria</option>
                                    <option value="Niue">Niue</option>
                                    <option value="Norfolk Island">Norfolk Island</option>
                                    <option value="Norway">Norway</option>
                                    <option value="Oman">Oman</option>
                                    <option value="Pakistan">Pakistan</option>
                                    <option value="Palau Island">Palau Island</option>
                                    <option value="Palestine">Palestine</option>
                                    <option value="Panama">Panama</option>
                                    <option value="Papua New Guinea">Papua New Guinea</option>
                                    <option value="Paraguay">Paraguay</option>
                                    <option value="Peru">Peru</option>
                                    <option value="Phillipines">Philippines</option>
                                    <option value="Pitcairn Island">Pitcairn Island</option>
                                    <option value="Poland">Poland</option>
                                    <option value="Portugal">Portugal</option>
                                    <option value="Puerto Rico">Puerto Rico</option>
                                    <option value="Qatar">Qatar</option>
                                    <option value="Republic of Montenegro">Republic of Montenegro</option>
                                    <option value="Republic of Serbia">Republic of Serbia</option>
                                    <option value="Reunion">Reunion</option>
                                    <option value="Romania">Romania</option>
                                    <option value="Russia">Russia</option>
                                    <option value="Rwanda">Rwanda</option>
                                    <option value="St Barthelemy">St Barthelemy</option>
                                    <option value="St Eustatius">St Eustatius</option>
                                    <option value="St Helena">St Helena</option>
                                    <option value="St Kitts-Nevis">St Kitts-Nevis</option>
                                    <option value="St Lucia">St Lucia</option>
                                    <option value="St Maarten">St Maarten</option>
                                    <option value="St Pierre &amp; Miquelon">St Pierre &amp; Miquelon</option>
                                    <option value="St Vincent &amp; Grenadines">St Vincent &amp; Grenadines</option>
                                    <option value="Saipan">Saipan</option>
                                    <option value="Samoa">Samoa</option>
                                    <option value="Samoa American">Samoa American</option>
                                    <option value="San Marino">San Marino</option>
                                    <option value="Sao Tome &amp; Principe">Sao Tome &amp; Principe</option>
                                    <option value="Saudi Arabia">Saudi Arabia</option>
                                    <option value="Senegal">Senegal</option>
                                    <option value="Serbia">Serbia</option>
                                    <option value="Seychelles">Seychelles</option>
                                    <option value="Sierra Leone">Sierra Leone</option>
                                    <option value="Singapore">Singapore</option>
                                    <option value="Slovakia">Slovakia</option>
                                    <option value="Slovenia">Slovenia</option>
                                    <option value="Solomon Islands">Solomon Islands</option>
                                    <option value="Somalia">Somalia</option>
                                    <option value="South Africa">South Africa</option>
                                    <option value="Spain">Spain</option>
                                    <option value="Sri Lanka">Sri Lanka</option>
                                    <option value="Sudan">Sudan</option>
                                    <option value="Suriname">Suriname</option>
                                    <option value="Swaziland">Swaziland</option>
                                    <option value="Sweden">Sweden</option>
                                    <option value="Switzerland">Switzerland</option>
                                    <option value="Syria">Syria</option>
                                    <option value="Tahiti">Tahiti</option>
                                    <option value="Taiwan">Taiwan</option>
                                    <option value="Tajikistan">Tajikistan</option>
                                    <option value="Tanzania">Tanzania</option>
                                    <option value="Thailand">Thailand</option>
                                    <option value="Togo">Togo</option>
                                    <option value="Tokelau">Tokelau</option>
                                    <option value="Tonga">Tonga</option>
                                    <option value="Trinidad &amp; Tobago">Trinidad &amp; Tobago</option>
                                    <option value="Tunisia">Tunisia</option>
                                    <option value="Turkey">Turkey</option>
                                    <option value="Turkmenistan">Turkmenistan</option>
                                    <option value="Turks &amp; Caicos Is">Turks &amp; Caicos Is</option>
                                    <option value="Tuvalu">Tuvalu</option>
                                    <option value="Uganda">Uganda</option>
                                    <option value="Ukraine">Ukraine</option>
                                    <option value="United Arab Erimates">United Arab Emirates</option>
                                    <option value="United Kingdom">United Kingdom</option>
                                    <option value="United States of America">United States of America</option>
                                    <option value="Uraguay">Uruguay</option>
                                    <option value="Uzbekistan">Uzbekistan</option>
                                    <option value="Vanuatu">Vanuatu</option>
                                    <option value="Vatican City State">Vatican City State</option>
                                    <option value="Venezuela">Venezuela</option>
                                    <option value="Vietnam">Vietnam</option>
                                    <option value="Virgin Islands (Brit)">Virgin Islands (Brit)</option>
                                    <option value="Virgin Islands (USA)">Virgin Islands (USA)</option>
                                    <option value="Wake Island">Wake Island</option>
                                    <option value="Wallis &amp; Futana Is">Wallis &amp; Futana Is</option>
                                    <option value="Yemen">Yemen</option>
                                    <option value="Zaire">Zaire</option>
                                    <option value="Zambia">Zambia</option>
                                    <option value="Zimbabwe">Zimbabwe</option>
                                </select>
                                <span></span>
                            </div>


                            <div class="form-group">
                                ><p>City: </p>
                                <input class="form-control" id="city" name="city">
                                <span></span>
                            </div>

                            <div class="form-group">
                                <p>Address: </p>
                                <input class="form-control" id="address" name="address">
                                <span></span>
                            </div>

                            <div class="form-group">
                                <p>Description: </p>
                                <textarea  class="form-control" style="resize: none" id="description" rows="10" cols="15" name="description"></textarea>
                                <span></span>
                            </div>

                            <div class="form-group">
                                <p>Display Picture: </p>
                                <input type="file" name="displayPicture" id="displayPicture" />
                                <span></span>
                            </div>

                            <div class="form-group">
                                <p>Time Zone: </p>
                                <select name="timezone">
                                    <option value="-12">(GMT-12:00) International Date Line West</option>
                                    <option value="-11">(GMT-11:00) Midway Island, Samoa</option>
                                    <option value="-10">(GMT-10:00) Hawaii</option>
                                    <option value="-9">(GMT-09:00) Alaska</option>
                                    <option value="-8">(GMT-08:00) Pacific Time (US & Canada)</option>
                                    <option value="-8">(GMT-08:00) Tijuana, Baja California</option>
                                    <option value="-7">(GMT-07:00) Arizona</option>
                                    <option value="-7">(GMT-07:00) Chihuahua, La Paz, Mazatlan</option>
                                    <option value="-7">(GMT-07:00) Mountain Time (US & Canada)</option>
                                    <option value="-6">(GMT-06:00) Central America</option>
                                    <option value="-6">(GMT-06:00) Central Time (US & Canada)</option>
                                    <option value="-6">(GMT-06:00) Guadalajara, Mexico City, Monterrey</option>
                                    <option value="-6">(GMT-06:00) Saskatchewan</option>
                                    <option value="-5">(GMT-05:00) Bogota, Lima, Quito, Rio Branco</option>
                                    <option value="-5">(GMT-05:00) Eastern Time (US & Canada)</option>
                                    <option value="-5">(GMT-05:00) Indiana (East)</option>
                                    <option value="-4">(GMT-04:00) Atlantic Time (Canada)</option>
                                    <option value="-4">(GMT-04:00) Caracas, La Paz</option>
                                    <option value="-4">(GMT-04:00) Manaus</option>
                                    <option value="-4">(GMT-04:00) Santiago</option>
                                    <option value="-3.5">(GMT-03:30) Newfoundland</option>
                                    <option value="-3">(GMT-03:00) Brasilia</option>
                                    <option value="-3">(GMT-03:00) Buenos Aires, Georgetown</option>
                                    <option value="-3">(GMT-03:00) Greenland</option>
                                    <option value="-3">(GMT-03:00) Montevideo</option>
                                    <option value="-2">(GMT-02:00) Mid-Atlantic</option>
                                    <option value="-1">(GMT-01:00) Cape Verde Is.</option>
                                    <option value="-1">(GMT-01:00) Azores</option>
                                    <option value="0">(GMT+00:00) Casablanca, Monrovia, Reykjavik</option>
                                    <option value="0">(GMT+00:00) Greenwich Mean Time : Dublin, Edinburgh, Lisbon, London</option>
                                    <option value="1">(GMT+01:00) Amsterdam, Berlin, Bern, Rome, Stockholm, Vienna</option>
                                    <option value="1">(GMT+01:00) Belgrade, Bratislava, Budapest, Ljubljana, Prague</option>
                                    <option value="1">(GMT+01:00) Brussels, Copenhagen, Madrid, Paris</option>
                                    <option value="1">(GMT+01:00) Sarajevo, Skopje, Warsaw, Zagreb</option>
                                    <option value="1">(GMT+01:00) West Central Africa</option>
                                    <option value="2">(GMT+02:00) Amman</option>
                                    <option value="2">(GMT+02:00) Athens, Bucharest, Istanbul</option>
                                    <option value="2">(GMT+02:00) Beirut</option>
                                    <option value="2">(GMT+02:00) Cairo</option>
                                    <option value="2">(GMT+02:00) Harare, Pretoria</option>
                                    <option value="2">(GMT+02:00) Helsinki, Kyiv, Riga, Sofia, Tallinn, Vilnius</option>
                                    <option value="2">(GMT+02:00) Jerusalem</option>
                                    <option value="2">(GMT+02:00) Minsk</option>
                                    <option value="2">(GMT+02:00) Windhoek</option>
                                    <option value="3">(GMT+03:00) Kuwait, Riyadh, Baghdad</option>
                                    <option value="3">(GMT+03:00) Moscow, St. Petersburg, Volgograd</option>
                                    <option value="3">(GMT+03:00) Nairobi</option>
                                    <option value="3">(GMT+03:00) Tbilisi</option>
                                    <option value="3.5">(GMT+03:30) Tehran</option>
                                    <option value="4">(GMT+04:00) Abu Dhabi, Muscat</option>
                                    <option value="4">(GMT+04:00) Baku</option>
                                    <option value="4">(GMT+04:00) Yerevan</option>
                                    <option value="4.5">(GMT+04:30) Kabul</option>
                                    <option value="5">(GMT+05:00) Yekaterinburg</option>
                                    <option value="5">(GMT+05:00) Islamabad, Karachi, Tashkent</option>
                                    <option value="5.5">(GMT+05:30) Sri Jayawardenapura</option>
                                    <option value="5.5">(GMT+05:30) Chennai, Kolkata, Mumbai, New Delhi</option>
                                    <option value="5.75">(GMT+05:45) Kathmandu</option>
                                    <option value="6">(GMT+06:00) Almaty, Novosibirsk</option>
                                    <option value="6">(GMT+06:00) Astana, Dhaka</option>
                                    <option value="6.5">(GMT+06:30) Yangon (Rangoon)</option>
                                    <option value="7">(GMT+07:00) Bangkok, Hanoi, Jakarta</option>
                                    <option value="7">(GMT+07:00) Krasnoyarsk</option>
                                    <option value="8">(GMT+08:00) Beijing, Chongqing, Hong Kong, Urumqi</option>
                                    <option value="8">(GMT+08:00) Kuala Lumpur, Singapore</option>
                                    <option value="8">(GMT+08:00) Irkutsk, Ulaan Bataar</option>
                                    <option value="8">(GMT+08:00) Perth</option>
                                    <option value="8">(GMT+08:00) Taipei</option>
                                    <option value="9">(GMT+09:00) Osaka, Sapporo, Tokyo</option>
                                    <option value="9">(GMT+09:00) Seoul</option>
                                    <option value="9">(GMT+09:00) Yakutsk</option>
                                    <option value="9.5">(GMT+09:30) Adelaide</option>
                                    <option value="9.5">(GMT+09:30) Darwin</option>
                                    <option value="10">(GMT+10:00) Brisbane</option>
                                    <option value="10">(GMT+10:00) Canberra, Melbourne, Sydney</option>
                                    <option value="10">(GMT+10:00) Hobart</option>
                                    <option value="10">(GMT+10:00) Guam, Port Moresby</option>
                                    <option value="10">(GMT+10:00) Vladivostok</option>
                                    <option value="11">(GMT+11:00) Magadan, Solomon Is., New Caledonia</option>
                                    <option value="12">(GMT+12:00) Auckland, Wellington</option>
                                    <option value="12">(GMT+12:00) Fiji, Kamchatka, Marshall Is.</option>
                                    <option value="13">(GMT+13:00) Nuku'alofa</option>
                                </select>
                                <span></span>
                            </div>

                            <div class="form-group">
                                <p>Password: </p>
                                <input type="password" class="form-control" id="password" ng-model="" name="password" required  >
                                <span id="password_message"></span>
                            </div>

                            <div class="form-group">
                                <p>Verify Password: </p>
                                <input type="password" class="form-control" id="cmfpassword" name="cmfpassword" required >
                                <span id="verify_password_message"></span>
                            </div>

                            <div class="form-group">
                                <button type="submit" class="btn btn-default">Submit</button>
                            </div>
                        </form>
                    </div>
                    <div class="col-md-4" style="width: 100%"></div>
                </div>
            </div>
            <script>

            </script>
        <jsp:include page="footer/footer.jsp" flush="true" ></jsp:include>
    </body>
</html>
