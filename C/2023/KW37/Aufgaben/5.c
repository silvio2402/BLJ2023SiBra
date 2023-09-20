#include <stdio.h>
#include <stdint.h>

#define PI 3.1415926;

float g_r = 5.5;

void printip(uint32_t ip)
{
  uint8_t ip1 = (ip & 0xFF000000) >> 24;
  uint8_t ip2 = (ip & 0x00FF0000) >> 16;
  uint8_t ip3 = (ip & 0x0000FF00) >> 8;
  uint8_t ip4 = ip & 0x000000FF;

  printf("%u.%u.%u.%u", ip1, ip2, ip3, ip4);
}

int main()
{
  // 1
  unsigned int x = 23;
  unsigned int y = 7;
  float p = 33.333;
  float q = 3.001;
  unsigned int a = 1;
  unsigned int b = 2;
  unsigned int c = 3;

  printf("%d\n", 3 + 4 * 2 - 10);

  printf("\n");

  // 2.2
  printf("%.1f\n", (float)x / y);
  printf("%d\n", x % y);

  printf("\n");

  // 2.3
  printf("%.01f\n", p / q);
  // printf("%d\n", p % q); // error: expression must have integral type

  printf("\n");

  // 3
  printf("Ausdruck a == b:\t%d\n", (a == b));
  printf("Ausdruck a != b:\t%d\n", (a != b));
  printf("Ausdruck b < 10:\t%d\n", (b < 10));
  printf("Ausdruck c >= 3:\t%d\n", (c >= 3));
  printf("Ausdruck 1 >= 1 && 2 == 2:\t%d\n", (1 >= 1 && 2 == 2));
  printf("Ausdruck 1 == 0 || 3 == 3:\t%d\n", (1 == 0 || 3 == 3));
  printf("Ausdruck !(1 == 0):\t%d\n", !(1 == 0));

  printf("\n");

  // 4.2
  a = 1;
  printf("%d\n", ++a); // 2, a = 2
  printf("%d\n", a--); // 2, a = 1
  printf("%d\n", a++); // 1, a = 2
  printf("%d\n", --a); // 1, a = 1

  printf("\n");

  // 4.2
  b = ++a + a++;
  printf("%d\n", a); // 3
  printf("%d\n", b); // 5

  printf("\n");

  // 5.1
  printf("AND\t0x%02x & 0x%02x = 0x%02x\n", 0xF, 0x4, 0xF & 0x4);

  // 5.2
  printf("OR\t0x%02x | 0x%02x = 0x%02x\n", 0xF, 0x4, 0xF | 0x4);

  // 5.3
  printf("XOR\t0x%02x ^ 0x%02x = 0x%02x\n", 0xF, 0x4, 0xF ^ 0x4);

  // 5.4
  printf("LSH\t0x%02x << %d   = 0x%02x\n", 0xF, 2, 0xF << 2);

  // 5.5
  printf("RSH\t0x%02x >> %d   = 0x%02x\n", 0xF, 2, 0xF >> 2);

  // 5.6
  printf("INV \t~ 0x%02x      = 0x%02x\n", 0xA, ~0xA);

  printf("\n");

  // 6.1
  unsigned char uch = 0b01100110;

  // 6.2
  uch |= 0b10000000;

  // 6.3
  uch &= 0b10101010;

  // 6.4
  uch ^= 0b01010101;

  // 6.5
  uch |= 0b11110000;

  // 6.6
  uint8_t ip1 = 128;
  uint8_t ip2 = 230;
  uint8_t ip3 = 130;
  uint8_t ip4 = 10;

  // 6.7
  unsigned char sf = 28;

  // 6.9
  uint32_t nm = ~(0xFFFFFFFF >> sf);
  printf("Netzwerkmaske von CIDR Suffix %u ist %x\n", sf, nm);

  printf("\n");

  // 6.11
  uint32_t ip32bit = ip1 << 24 | ip2 << 16 | ip3 << 8 | ip4;
  printf("IP %u.%u.%u.%u als Hexadezimalwert: %x\n", ip1, ip2, ip3, ip4, ip32bit);

  printf("\n");

  // 6.13
  uint32_t nwaddr = ip32bit & nm;
  uint32_t bcaddr = (ip32bit & nm) | ~nm;
  printf("Netzwerkadresse: %x\n", nwaddr);
  printf("Broadcastadresse: %x\n", bcaddr);

  printf("\n");

  // 6.15
  printf("Netzwerkadresse: ", nwaddr);
  printip(nwaddr);
  printf("\nBroadcastadresse: ", bcaddr);
  printip(bcaddr);
  printf("\n");

  printf("\n");

  // 6.17
  unsigned int numhosts = (0xFFFFFFFF >> sf) + 1;
  printf("Aus dem CIDR Suffix %u ergeben sich %u Hosts\n", sf, numhosts);

  return 0;
}
