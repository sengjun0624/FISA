"use client"

import type React from "react"

import { useState, useEffect } from "react"
import { Input } from "@/components/ui/input"
import { Button } from "@/components/ui/button"
import { Label } from "@/components/ui/label"
import { Card, CardContent } from "@/components/ui/card"
const API_BASE_URL = process.env.NEXT_PUBLIC_API_BASE_URL || "http://localhost:8080";

interface OwnerFormProps {
  ownerId?: number
  onSuccess: (id: number) => void
}

interface OwnerFormData {
  firstName: string
  lastName: string
  address: string
  city: string
  telephone: string
}

export default function OwnerForm({ ownerId, onSuccess }: OwnerFormProps) {
  const [formData, setFormData] = useState<OwnerFormData>({
    firstName: "",
    lastName: "",
    address: "",
    city: "",
    telephone: "",
  })
  const [isLoading, setIsLoading] = useState(false)
  const [error, setError] = useState<string | null>(null)
  const [isLoadingOwner, setIsLoadingOwner] = useState(!!ownerId)

  useEffect(() => {
    if (ownerId) {
      const fetchOwner = async () => {
        try {
          const response = await fetch(`http://localhost:8080/owners/${ownerId}`)

          if (!response.ok) {
            throw new Error("소유자 정보를 불러오는 중 오류가 발생했습니다")
          }

          const data = await response.json()
          setFormData({
            firstName: data.firstName,
            lastName: data.lastName,
            address: data.address,
            city: data.city,
            telephone: data.telephone,
          })
        } catch (err) {
          setError(err instanceof Error ? err.message : "소유자 정보를 불러오는 중 오류가 발생했습니다")
        } finally {
          setIsLoadingOwner(false)
        }
      }

      fetchOwner()
    }
  }, [ownerId])

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target
    setFormData((prev) => ({ ...prev, [name]: value }))
  }

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault()
    setIsLoading(true)
    setError(null)

    try {
      const url = ownerId ? `http://localhost:8080/owners/edit?id=${ownerId}` : "http://localhost:8080/owners/new"

      const response = await fetch(url, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      })

      if (!response.ok) {
        throw new Error("저장 중 오류가 발생했습니다")
      }

      const data = await response.json()
      onSuccess(data.id)
    } catch (err) {
      setError(err instanceof Error ? err.message : "저장 중 오류가 발생했습니다")
    } finally {
      setIsLoading(false)
    }
  }

  if (isLoadingOwner) {
    return <div className="text-center py-10">정보를 불러오는 중...</div>
  }

  return (
    <Card>
      <CardContent className="pt-6">
        <form onSubmit={handleSubmit} className="space-y-4">
          <div className="grid grid-cols-2 gap-4">
            <div className="space-y-2">
              <Label htmlFor="firstName" className="text-[#333D4B]">
                이름
              </Label>
              <Input
                id="firstName"
                name="firstName"
                value={formData.firstName}
                onChange={handleChange}
                required
                className="h-12 rounded-xl border-gray-200 focus:border-[#3182F6] focus:ring-[#3182F6]"
              />
            </div>
            <div className="space-y-2">
              <Label htmlFor="lastName" className="text-[#333D4B]">
                성
              </Label>
              <Input
                id="lastName"
                name="lastName"
                value={formData.lastName}
                onChange={handleChange}
                required
                className="h-12 rounded-xl border-gray-200 focus:border-[#3182F6] focus:ring-[#3182F6]"
              />
            </div>
          </div>

          <div className="space-y-2">
            <Label htmlFor="address" className="text-[#333D4B]">
              주소
            </Label>
            <Input
              id="address"
              name="address"
              value={formData.address}
              onChange={handleChange}
              required
              className="h-12 rounded-xl border-gray-200 focus:border-[#3182F6] focus:ring-[#3182F6]"
            />
          </div>

          <div className="space-y-2">
            <Label htmlFor="city" className="text-[#333D4B]">
              도시
            </Label>
            <Input
              id="city"
              name="city"
              value={formData.city}
              onChange={handleChange}
              required
              className="h-12 rounded-xl border-gray-200 focus:border-[#3182F6] focus:ring-[#3182F6]"
            />
          </div>

          <div className="space-y-2">
            <Label htmlFor="telephone" className="text-[#333D4B]">
              전화번호
            </Label>
            <Input
              id="telephone"
              name="telephone"
              value={formData.telephone}
              onChange={handleChange}
              required
              className="h-12 rounded-xl border-gray-200 focus:border-[#3182F6] focus:ring-[#3182F6]"
            />
          </div>

          {error && <div className="p-3 text-center text-red-500 bg-red-50 rounded-xl">{error}</div>}

          <Button
            type="submit"
            disabled={isLoading}
            className="w-full h-12 rounded-xl bg-[#3182F6] hover:bg-[#1b64da] text-white font-medium"
          >
            {isLoading ? "저장 중..." : ownerId ? "수정하기" : "등록하기"}
          </Button>
        </form>
      </CardContent>
    </Card>
  )
}

